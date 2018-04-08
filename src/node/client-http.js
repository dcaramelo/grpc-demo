metrics = require('./data-connectors/metrics')

const MESSAGE_PATH = process.env.MESSAGE || '../../benchmark/fixtures/short-message.json'
const HOST = process.env.HOST || 'localhost'

let MESSAGE = require(MESSAGE_PATH)

const request = require('request');
const express = require('express')
const app = express()

const main = function() {

  app.get('/test_http', function (req, res) {
    var options = {
      url: 'http://' + HOST + ':5000/test_http',
      rejectUnauthorized : false,
      json: true,
      forever: true,
      body: MESSAGE
    }
    const init_date = Date.now()
    request({
      url: 'http://' + HOST + ':5000/test_http',
      method: "POST",
      rejectUnauthorized : false,
      json: true,
      forever: true,
      body: MESSAGE
    }, function(err, resp, body) {
      metrics.save("grpc_bench.client.http", Date.now() - init_date)
      res.send('Hello Test!')
    })

  })

  app.listen(3000, function () {
    console.log('Example app listening on port 3000!')
  })

}

main()
