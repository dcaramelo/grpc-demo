const LazySocket = require('lazy-socket')

const url = require('url')

module.exports = class CarbonClient {
  constructor(properties) {
    properties = properties || {}
    this._dsn = properties.dsn
    this._socket = properties.socket || null
  }

  write(metrics, timestamp, cb) {
    this.lazyConnect()
    let lines = ''
    for (let path in metrics) {
      let value = metrics[path]
      lines += [path, value, timestamp].join(' ') + '\n'
    }
    //console.log lines
    return this._socket.write(lines, 'utf-8', cb)
  }

  lazyConnect() {
    if (this._socket) {
      return
    }
    const dsn = url.parse(this._dsn)
    const port = parseInt(dsn.port, 10) || 2003
    const host = dsn.hostname
    return this._socket = LazySocket.createConnection(port, host)
  }

  end() {
    if (this._socket != null) {
      return this._socket.end()
    }
  }

}
