// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: example.proto

package demo.beans.proto;

public final class DemoProto {
  private DemoProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_demo_beans_proto_MessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_demo_beans_proto_MessageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_demo_beans_proto_MessageReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_demo_beans_proto_MessageReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rexample.proto\022\020demo.beans.proto\"\036\n\016Mes" +
      "sageRequest\022\014\n\004name\030\001 \001(\t\"{\n\014MessageRepl" +
      "y\022;\n\007success\030\001 \001(\0162*.demo.beans.proto.Me" +
      "ssageReply.EnumSuccess\022\017\n\007message\030\002 \001(\t\"" +
      "\035\n\013EnumSuccess\022\006\n\002OK\020\000\022\006\n\002KO\020\0012\375\002\n\007Examp" +
      "le\022Q\n\013SendMessage\022 .demo.beans.proto.Mes" +
      "sageRequest\032\036.demo.beans.proto.MessageRe" +
      "ply\"\000\022Y\n\021SendMessageStream\022 .demo.beans." +
      "proto.MessageRequest\032\036.demo.beans.proto." +
      "MessageReply\"\000(\001\022a\n\031SendMessageStreamRes",
      "ponse\022 .demo.beans.proto.MessageRequest\032" +
      "\036.demo.beans.proto.MessageReply\"\0000\001\022a\n\027S" +
      "endMessageStreamDuplex\022 .demo.beans.prot" +
      "o.MessageRequest\032\036.demo.beans.proto.Mess" +
      "ageReply\"\000(\0010\001B\rB\tDemoProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_demo_beans_proto_MessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_demo_beans_proto_MessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_demo_beans_proto_MessageRequest_descriptor,
        new String[] { "Name", });
    internal_static_demo_beans_proto_MessageReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_demo_beans_proto_MessageReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_demo_beans_proto_MessageReply_descriptor,
        new String[] { "Success", "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
