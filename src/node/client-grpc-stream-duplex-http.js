var express = require('express');
var app = express();

var PROTO_PATH = process.env.PROTO;

var grpc = require('grpc');
var ogury_proto = grpc.load(PROTO_PATH).ogury;

var message = require(process.env.MESSAGE);

function main() {
    var client = new ogury_proto.Data(process.env.HOST + ':50052', grpc.credentials.createInsecure());

    var call = client.sendMessageStreamDuplex();

    var queue = {};
    var correlationId = 0;

    call.on('data', function(data) {
        console.log(data.id);
        queue[data.id]();
        delete queue[data.id];
    });

    app.get('/ping', function (req, res) {
        id = correlationId++;
        m = {id: id, api_key: "123445", version: "1.4.0", field1: "test-test"};
        queue[id] = function (res) {
            return function () {
                res.status(200).send({});
            }
        }(res);
        call.write(m);
    });
    app.listen(8080);

}

main();