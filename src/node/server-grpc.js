const PROTO_PATH = process.env.PROTO || '../main/proto/example.proto'

const grpc = require('grpc')
const example_proto = grpc.load(PROTO_PATH).demo.beans.proto

const os = require('os')

function sendMessageSimple(call, callback) {
  callback(null, {success: 'OK', message: `Hello ${call.request.name}`})
}

function sendMessageStream(call, callback) {
  let name
  call.on('data', function(message) {
    name = message.name
  })
  call.on('end', function() {
    callback(null, {success: 'OK', message: `Hello ${name}`})
  })
}

function sendMessageStreamResponse(call) {
  call.write({success: 'OK', message: `Hello ${call.request.name}`})
  call.end()
}

function sendMessageStreamDuplex(call) {
  call.on('data', function(message) {
    call.write({id: message.id, success: 'OK', message: `Hello ${message.name}`})
  })
  call.on('end', function() {
    call.end()
  })
}

const main = function() {
  const server = new grpc.Server()
  server.addService(example_proto.Example.service, {
    sendMessageSimple: sendMessageSimple,
    sendMessageStream: sendMessageStream,
    sendMessageStreamResponse: sendMessageStreamResponse,
    sendMessageStreamDuplex: sendMessageStreamDuplex
  })

  setInterval(function() {
    // console.log(os.loadavg());
  }, 1000)

  server.bind('0.0.0.0:50052', grpc.ServerCredentials.createInsecure())
  server.start()
}

main()
