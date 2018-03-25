const CarbonClient = require('./carbon-client')

module.exports = class GraphiteClient {
  constructor(carbonDsn) {
    this._carbon = new CarbonClient({
      dsn: carbonDsn
    })
  }

  flatten(obj, flat, prefix) {
    let key, value
    flat = flat || {}
    prefix = prefix || ''
    if (prefix !== '' && prefix.slice(-1) !== '.') {
      prefix = prefix + '.'
    }
    for (key in obj) {
      value = obj[key]
      if (typeof value === 'object') {
        this.flatten(value, flat, prefix + key + '.')
      } else {
        flat[prefix + key] = value
      }
    }
    return flat
  }

  write(prefix, metrics, timestamp, cb) {
    if (typeof timestamp === 'function') {
      cb = timestamp
      timestamp = null
    }
    timestamp = timestamp || Date.now()
    timestamp = Math.floor(timestamp / 1000)
    return this._carbon.write(this.flatten(metrics, null, prefix), timestamp, cb)
  }

  end() {
    return this._carbon.end()
  }

}
