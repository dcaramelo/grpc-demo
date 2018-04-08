const GraphiteClient = require('./graphite-connector/graphite-client');

class Graphite {
  constructor() {
    const host = process.env.GRAPHITE_HOST
    this.prefixEnv = process.env.GRAPHITE_PREFIX || ''
    this._active = false
    if (host != null) {
      this._client = new GraphiteClient(`plaintext://${host}`)
      this._active = true
    } else {
      console.log('error', 'No graphite configuration found (GRAPHITE_HOST)')
    }
  }

  isActive() {
    return this._active
  }

  send(metrics) {
    if (this._active) {
      if (typeof metrics.toJSON === 'function') {
        return this._client.write(this.prefixEnv, metrics.toJSON())
      } else {
        return this._client.write(this.prefixEnv, metrics)
      }
    }
  }

}

module.exports = new Graphite()
