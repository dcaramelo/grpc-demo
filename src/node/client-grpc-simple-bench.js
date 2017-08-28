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

const client = new example_proto.Example(HOST + ':50052', grpc.credentials.createInsecure())

const rps = collection.meter('rps')
const duration = collection.histogram('duration')

newReq = function() {
  return function(callback) {
    const init_time = Date.now()
    client.sendMessage(MESSAGE, function(err, response) {
      duration.update(Date.now() - init_time)
      rps.mark()
      callback()
    })

  }
}

const main = function() {

  var tasks = [];
  for (var i = 0; i < 100000; i++) {
    tasks[i] = newReq();
  }
  async.series(tasks, function() {
    console.log(collection.toJSON());
  });

}

main()
