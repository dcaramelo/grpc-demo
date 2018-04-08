package demo.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: example.proto")
public final class ExampleGrpc {

  private ExampleGrpc() {}

  public static final String SERVICE_NAME = "demo.beans.proto.Example";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<demo.beans.proto.MessageRequest,
      demo.beans.proto.MessageReply> METHOD_SEND_MESSAGE =
      io.grpc.MethodDescriptor.<demo.beans.proto.MessageRequest, demo.beans.proto.MessageReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "demo.beans.proto.Example", "SendMessageSimple"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.beans.proto.MessageRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.beans.proto.MessageReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<demo.beans.proto.MessageRequest,
      demo.beans.proto.MessageReply> METHOD_SEND_MESSAGE_STREAM =
      io.grpc.MethodDescriptor.<demo.beans.proto.MessageRequest, demo.beans.proto.MessageReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "demo.beans.proto.Example", "SendMessageStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.beans.proto.MessageRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.beans.proto.MessageReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<demo.beans.proto.MessageRequest,
      demo.beans.proto.MessageReply> METHOD_SEND_MESSAGE_STREAM_RESPONSE =
      io.grpc.MethodDescriptor.<demo.beans.proto.MessageRequest, demo.beans.proto.MessageReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "demo.beans.proto.Example", "SendMessageStreamResponse"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.beans.proto.MessageRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.beans.proto.MessageReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<demo.beans.proto.MessageRequest,
      demo.beans.proto.MessageReply> METHOD_SEND_MESSAGE_STREAM_DUPLEX =
      io.grpc.MethodDescriptor.<demo.beans.proto.MessageRequest, demo.beans.proto.MessageReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "demo.beans.proto.Example", "SendMessageStreamDuplex"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.beans.proto.MessageRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.beans.proto.MessageReply.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExampleStub newStub(io.grpc.Channel channel) {
    return new ExampleStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExampleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ExampleBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExampleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ExampleFutureStub(channel);
  }

  /**
   */
  public static abstract class ExampleImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendMessageSimple(demo.beans.proto.MessageRequest request,
        io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<demo.beans.proto.MessageRequest> sendMessageStream(
        io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_SEND_MESSAGE_STREAM, responseObserver);
    }

    /**
     */
    public void sendMessageStreamResponse(demo.beans.proto.MessageRequest request,
        io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE_STREAM_RESPONSE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<demo.beans.proto.MessageRequest> sendMessageStreamDuplex(
        io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_SEND_MESSAGE_STREAM_DUPLEX, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEND_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                demo.beans.proto.MessageRequest,
                demo.beans.proto.MessageReply>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            METHOD_SEND_MESSAGE_STREAM,
            asyncClientStreamingCall(
              new MethodHandlers<
                demo.beans.proto.MessageRequest,
                demo.beans.proto.MessageReply>(
                  this, METHODID_SEND_MESSAGE_STREAM)))
          .addMethod(
            METHOD_SEND_MESSAGE_STREAM_RESPONSE,
            asyncServerStreamingCall(
              new MethodHandlers<
                demo.beans.proto.MessageRequest,
                demo.beans.proto.MessageReply>(
                  this, METHODID_SEND_MESSAGE_STREAM_RESPONSE)))
          .addMethod(
            METHOD_SEND_MESSAGE_STREAM_DUPLEX,
            asyncBidiStreamingCall(
              new MethodHandlers<
                demo.beans.proto.MessageRequest,
                demo.beans.proto.MessageReply>(
                  this, METHODID_SEND_MESSAGE_STREAM_DUPLEX)))
          .build();
    }
  }

  /**
   */
  public static final class ExampleStub extends io.grpc.stub.AbstractStub<ExampleStub> {
    private ExampleStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ExampleStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExampleStub(channel, callOptions);
    }

    /**
     */
    public void sendMessageSimple(demo.beans.proto.MessageRequest request,
        io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<demo.beans.proto.MessageRequest> sendMessageStream(
        io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_STREAM, getCallOptions()), responseObserver);
    }

    /**
     */
    public void sendMessageStreamResponse(demo.beans.proto.MessageRequest request,
        io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_STREAM_RESPONSE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<demo.beans.proto.MessageRequest> sendMessageStreamDuplex(
        io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_STREAM_DUPLEX, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ExampleBlockingStub extends io.grpc.stub.AbstractStub<ExampleBlockingStub> {
    private ExampleBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ExampleBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExampleBlockingStub(channel, callOptions);
    }

    /**
     */
    public demo.beans.proto.MessageReply sendMessageSimple(demo.beans.proto.MessageRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_MESSAGE, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<demo.beans.proto.MessageReply> sendMessageStreamResponse(
        demo.beans.proto.MessageRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_SEND_MESSAGE_STREAM_RESPONSE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ExampleFutureStub extends io.grpc.stub.AbstractStub<ExampleFutureStub> {
    private ExampleFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ExampleFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExampleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<demo.beans.proto.MessageReply> sendMessageSimple(
        demo.beans.proto.MessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_SEND_MESSAGE_STREAM_RESPONSE = 1;
  private static final int METHODID_SEND_MESSAGE_STREAM = 2;
  private static final int METHODID_SEND_MESSAGE_STREAM_DUPLEX = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExampleImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExampleImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessageSimple((demo.beans.proto.MessageRequest) request,
              (io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE_STREAM_RESPONSE:
          serviceImpl.sendMessageStreamResponse((demo.beans.proto.MessageRequest) request,
              (io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendMessageStream(
              (io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply>) responseObserver);
        case METHODID_SEND_MESSAGE_STREAM_DUPLEX:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendMessageStreamDuplex(
              (io.grpc.stub.StreamObserver<demo.beans.proto.MessageReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ExampleDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return demo.beans.proto.DemoProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ExampleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExampleDescriptorSupplier())
              .addMethod(METHOD_SEND_MESSAGE)
              .addMethod(METHOD_SEND_MESSAGE_STREAM)
              .addMethod(METHOD_SEND_MESSAGE_STREAM_RESPONSE)
              .addMethod(METHOD_SEND_MESSAGE_STREAM_DUPLEX)
              .build();
        }
      }
    }
    return result;
  }
}
