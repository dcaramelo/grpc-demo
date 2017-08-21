var PROTO_PATH = process.env.PROTO;

var async = require('async');
var grpc = require('grpc');
var ogury_proto = grpc.load(PROTO_PATH).ogury;

var message = require(process.env.MESSAGE);

function main() {
    var client = new ogury_proto.Data(process.env.HOST + ':50052', grpc.credentials.createInsecure());

    var newReq = function() {
        return function(callback) {
            call.write(message);
            setTimeout(callback, 1000);
        }
    }

    var call = client.sendMessageStreamDuplex();

    c = 0
    call.on('data', function(data) {
        console.log("Data Received", c++);
    });
    call.on('end', function() {
        console.log("Data End");
    });
    call.on('status', function(status) {
        console.log("Data status", status);
    });

    var tasks = [];
    for (var i = 0; i < 10; i++) {
        tasks[i] = newReq();
    }
    async.series(tasks, function() {
        call.end();
    });
}

main();