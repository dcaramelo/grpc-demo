const PROTO_PATH = process.env.PROTO || '../main/proto/example.proto'
const MESSAGE_PATH = process.env.MESSAGE || '../../benchmark/fixtures/short-message.json'
const HOST = process.env.HOST || 'localhost'

const MESSAGE = require(MESSAGE_PATH)

const express = require('express')
const app = express()

const grpc = require('grpc')
const example_proto = grpc.load(PROTO_PATH).demo.beans.proto
const client = new example_proto.Example(HOST + ':50052', grpc.credentials.createInsecure())

const main = function() {

  client.sendMessage(MESSAGE, function(err, response) {
    console.log('Response:', response, err);
  })

  app.get('/test', function (req, res) {
    client.sendMessage(MESSAGE, function(err, response) {
      res.send('Hello Test!')
    })
  })

  app.listen(3000, function () {
    console.log('Example app listening on port 3000!')
  })

}

main()
