const PROTO_PATH = process.env.PROTO || '../main/proto/example.proto'
const HOST = process.env.HOST || 'localhost'

const MESSAGE = {
  name: 'Peter'
}

const request = require('request');
const async = require('async');
const Measured = require('measured')
const collection = new Measured.createCollection()

const rps = collection.meter('rps')
const duration = collection.histogram('duration')

newReq = function() {
  return function(callback) {

    var options = {
      url: 'http://' + HOST + ':5000/hello-world?name=Peter',
      rejectUnauthorized : false//,
      // json: true,
      // body: MESSAGE
    }
    const init_time = Date.now()
    request.get(options, function(err, data){
      duration.update(Date.now() - init_time)
      rps.mark()
      callback()
    });

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
