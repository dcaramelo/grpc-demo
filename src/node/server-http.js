const express = require('express')
const app = express()
const bodyParser = require('body-parser')
const os = require('os')

const main = function() {

  setInterval(function() {
    console.log(os.loadavg());
  }, 1000)

  app.use(bodyParser.json({limit: '300kb'}))

  app.post('/test_http', function (req, res) {
    res.send({
      name: req.body.name
    })
  })

  app.listen(5000, function () {
    console.log('Example app listening on port 5000!')
  })

}

main()
