const PROTO_PATH = process.env.PROTO || '../main/proto/example.proto'
const HOST = process.env.HOST || 'localhost'

const MESSAGE = {
  name: 'Peter'
}

const async = require('async');
const Measured = require('measured')
const collection = new Measured.createCollection()
const grpc = require('grpc')
const example_proto = grpc.load(PROTO_PATH).demo.beans.proto

const main = function() {
  const client = new example_proto.Example(HOST + ':50052', grpc.credentials.createInsecure())
  const call = client.sendMessageStreamDuplex()

  var init_time = null;

  const rps = collection.meter('rps')
  const duration = collection.histogram('duration')

  var cb = null


  const newReq = function() {
    return function(callback) {
      init_time = Date.now()
      call.write(MESSAGE)
      cb = callback
    }
  }

  var tasks = [];
  for (var i = 0; i < 100000; i++) {
    tasks[i] = newReq();
  }
  async.series(tasks, function() {
    console.log(collection.toJSON());
    call.end();
  });


  call.on('data', function(data) {
    duration.update(Date.now() - init_time)
    rps.mark()
    cb()
  })
  call.on('end', function() {
  })

}

main()
