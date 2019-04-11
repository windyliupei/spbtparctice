package com.windy.codepractice.grpclib;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.1)",
    comments = "Source: entity.proto")
public final class EntityDemoGrpc {

  private EntityDemoGrpc() {}

  public static final String SERVICE_NAME = "EntityDemo";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.windy.codepractice.grpclib.EntityOuterClass.EntityRep,
      com.windy.codepractice.grpclib.EntityOuterClass.EntityReply> getEntityByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EntityByName",
      requestType = com.windy.codepractice.grpclib.EntityOuterClass.EntityRep.class,
      responseType = com.windy.codepractice.grpclib.EntityOuterClass.EntityReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.windy.codepractice.grpclib.EntityOuterClass.EntityRep,
      com.windy.codepractice.grpclib.EntityOuterClass.EntityReply> getEntityByNameMethod() {
    io.grpc.MethodDescriptor<com.windy.codepractice.grpclib.EntityOuterClass.EntityRep, com.windy.codepractice.grpclib.EntityOuterClass.EntityReply> getEntityByNameMethod;
    if ((getEntityByNameMethod = EntityDemoGrpc.getEntityByNameMethod) == null) {
      synchronized (EntityDemoGrpc.class) {
        if ((getEntityByNameMethod = EntityDemoGrpc.getEntityByNameMethod) == null) {
          EntityDemoGrpc.getEntityByNameMethod = getEntityByNameMethod = 
              io.grpc.MethodDescriptor.<com.windy.codepractice.grpclib.EntityOuterClass.EntityRep, com.windy.codepractice.grpclib.EntityOuterClass.EntityReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "EntityDemo", "EntityByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.windy.codepractice.grpclib.EntityOuterClass.EntityRep.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.windy.codepractice.grpclib.EntityOuterClass.EntityReply.getDefaultInstance()))
                  .setSchemaDescriptor(new EntityDemoMethodDescriptorSupplier("EntityByName"))
                  .build();
          }
        }
     }
     return getEntityByNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EntityDemoStub newStub(io.grpc.Channel channel) {
    return new EntityDemoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EntityDemoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EntityDemoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EntityDemoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EntityDemoFutureStub(channel);
  }

  /**
   */
  public static abstract class EntityDemoImplBase implements io.grpc.BindableService {

    /**
     */
    public void entityByName(com.windy.codepractice.grpclib.EntityOuterClass.EntityRep request,
        io.grpc.stub.StreamObserver<com.windy.codepractice.grpclib.EntityOuterClass.EntityReply> responseObserver) {
      asyncUnimplementedUnaryCall(getEntityByNameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEntityByNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.windy.codepractice.grpclib.EntityOuterClass.EntityRep,
                com.windy.codepractice.grpclib.EntityOuterClass.EntityReply>(
                  this, METHODID_ENTITY_BY_NAME)))
          .build();
    }
  }

  /**
   */
  public static final class EntityDemoStub extends io.grpc.stub.AbstractStub<EntityDemoStub> {
    private EntityDemoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EntityDemoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityDemoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EntityDemoStub(channel, callOptions);
    }

    /**
     */
    public void entityByName(com.windy.codepractice.grpclib.EntityOuterClass.EntityRep request,
        io.grpc.stub.StreamObserver<com.windy.codepractice.grpclib.EntityOuterClass.EntityReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEntityByNameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EntityDemoBlockingStub extends io.grpc.stub.AbstractStub<EntityDemoBlockingStub> {
    private EntityDemoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EntityDemoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityDemoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EntityDemoBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.windy.codepractice.grpclib.EntityOuterClass.EntityReply entityByName(com.windy.codepractice.grpclib.EntityOuterClass.EntityRep request) {
      return blockingUnaryCall(
          getChannel(), getEntityByNameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EntityDemoFutureStub extends io.grpc.stub.AbstractStub<EntityDemoFutureStub> {
    private EntityDemoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EntityDemoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityDemoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EntityDemoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.windy.codepractice.grpclib.EntityOuterClass.EntityReply> entityByName(
        com.windy.codepractice.grpclib.EntityOuterClass.EntityRep request) {
      return futureUnaryCall(
          getChannel().newCall(getEntityByNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENTITY_BY_NAME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EntityDemoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EntityDemoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENTITY_BY_NAME:
          serviceImpl.entityByName((com.windy.codepractice.grpclib.EntityOuterClass.EntityRep) request,
              (io.grpc.stub.StreamObserver<com.windy.codepractice.grpclib.EntityOuterClass.EntityReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EntityDemoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EntityDemoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.windy.codepractice.grpclib.EntityOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EntityDemo");
    }
  }

  private static final class EntityDemoFileDescriptorSupplier
      extends EntityDemoBaseDescriptorSupplier {
    EntityDemoFileDescriptorSupplier() {}
  }

  private static final class EntityDemoMethodDescriptorSupplier
      extends EntityDemoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EntityDemoMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EntityDemoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EntityDemoFileDescriptorSupplier())
              .addMethod(getEntityByNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
