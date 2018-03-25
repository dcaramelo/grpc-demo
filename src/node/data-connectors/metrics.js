const Measured = require('measured')

const graphite = require('./graphite')
const collection = new Measured.createCollection()

class Metrics {
  constructor() {
    this.processInterval = null
    setInterval(function() {
      console.log(collection.toJSON());
    }, 1000)
  }

  save(metrics, timestamp) {
    var duration, rps
    if (graphite.isActive() && !this.processInterval) {
      this.processInterval = setInterval((function() {
        return graphite.send(collection)
      }), 10000)
    }
    rps = collection.meter(metrics + '.rps')
    duration = collection.histogram(metrics + '.duration')
    duration.update(timestamp)
    return rps.mark()
  }

}

module.exports = new Metrics()
