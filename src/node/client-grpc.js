metrics = require('./data-connectors/metrics')
const cloneDeep = require('clone-deep')

const PROTO_PATH = process.env.PROTO || '../main/proto/example.proto'
const MESSAGE_PATH = process.env.MESSAGE || '../../benchmark/fixtures/short-message.json'
const HOST = process.env.HOST || 'localhost'

let MESSAGE = require(MESSAGE_PATH)

const express = require('express')
const app = express()

const grpc = require('grpc')
const example_proto = grpc.load(PROTO_PATH).demo.beans.proto
const client = new example_proto.Example(HOST + ':50052', grpc.credentials.createInsecure())

const main = function() {

  // Init Full Duplex session
  const call = client.sendMessageStreamDuplex()
  call.on('end', function() {})

  process.on('SIGINT', function() {
    call.end()
    console.log("Caught interrupt signal")
    process.kill()
  })

  // Test first messages (stream and single)
  // call.write(MESSAGE)
  // client.sendMessageSimple(MESSAGE, function(err, response) {
  //   console.log('Response:', response, err);
  // })

  call.on('data', function(data) {
    callbacks[data.id]()
    delete callbacks[data.id]
  })

  let counter = 0
  callbacks = {}
  app.get('/test_stream', function (req, res) {
    const init_date = Date.now()
    const c = counter++
    let m = cloneDeep(MESSAGE)
    m.id = c
    callbacks[c] = function(res, init_date) {
      return function() {
        metrics.save("grpc_bench.client.stream", Date.now() - init_date)
        res.send('Hello Test!')
      }
    }(res, init_date)
    call.write(m)
  })

  app.get('/test_single', function (req, res) {
    const init_date = Date.now()
    client.sendMessageSimple(MESSAGE, function () {
      metrics.save("grpc_bench.client.single", Date.now() - init_date)
      res.send('Hello Test!')
    })
  })

  app.listen(3000, function () {
    console.log('Example app listening on port 3000!')
  })

}

main()
