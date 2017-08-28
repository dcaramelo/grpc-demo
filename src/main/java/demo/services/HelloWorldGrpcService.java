package demo.services;

import demo.beans.proto.MessageReply;
import demo.beans.proto.MessageRequest;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import demo.grpc.ExampleGrpc;


@GRpcService
public class HelloWorldGrpcService extends ExampleGrpc.ExampleImplBase {

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloWorldGrpcService.class);

    private Process process;

    @Autowired
    public HelloWorldGrpcService(final Process process) {
        this.process = process;
    }

    public void sendMessage(MessageRequest request, StreamObserver<MessageReply> responseObserver) {
        final MessageReply.Builder builder = MessageReply.newBuilder()
                .setMessage(process.transform(request.getName()))
                .setSuccess(MessageReply.EnumSuccess.OK);

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    public void sendMessageStreamResponse(MessageRequest request, StreamObserver<MessageReply> responseObserver) {
        final MessageReply.Builder builder = MessageReply.newBuilder()
                .setMessage(process.transform(request.getName()))
                .setSuccess(MessageReply.EnumSuccess.OK);

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    public StreamObserver<MessageRequest> sendMessageStream(StreamObserver<MessageReply> responseObserver) {
        return getStreamObserver(responseObserver);
    }

    public StreamObserver<MessageRequest> sendMessageStreamDuplex(StreamObserver<MessageReply> responseObserver) {
        return getStreamObserver(responseObserver);
    }

    private StreamObserver<MessageRequest> getStreamObserver(StreamObserver<MessageReply> responseObserver) {
        return new StreamObserver<MessageRequest>() {
            @Override
            public void onNext(final MessageRequest request) {
                final MessageReply.Builder builder = MessageReply.newBuilder()
                        .setMessage(process.transform(request.getName()))
                        .setSuccess(MessageReply.EnumSuccess.OK);

                responseObserver.onNext(builder.build());
            }

            @Override
            public void onError(final Throwable t) {
                LOGGER.error("gRPC error", t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
