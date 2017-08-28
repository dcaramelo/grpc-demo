const PROTO_PATH = process.env.PROTO || '../main/proto/example.proto'
const HOST = process.env.HOST || 'localhost'

const grpc = require('grpc')
const example_proto = grpc.load(PROTO_PATH).demo.beans.proto

const MESSAGE = {
  name: 'Peter'
}

const main = function() {
  const client = new example_proto.Example(HOST + ':50052', grpc.credentials.createInsecure())

  const call = client.sendMessageStreamDuplex()

  call.on('data', function(data) {
    console.log('Data Received', data)
  })
  call.on('end', function() {
  })

  call.write(MESSAGE)
  call.write(MESSAGE)
  call.write(MESSAGE)
  call.end()

}

main()