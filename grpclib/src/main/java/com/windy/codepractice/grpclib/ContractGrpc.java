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
 * <pre>
 * The Daimler service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.1)",
    comments = "Source: contract.proto")
public final class ContractGrpc {

  private ContractGrpc() {}

  public static final String SERVICE_NAME = "Contract";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest,
      com.windy.codepractice.grpclib.ContractOuterClass.ContractReply> getSayDaimlerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayDaimler",
      requestType = com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest.class,
      responseType = com.windy.codepractice.grpclib.ContractOuterClass.ContractReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest,
      com.windy.codepractice.grpclib.ContractOuterClass.ContractReply> getSayDaimlerMethod() {
    io.grpc.MethodDescriptor<com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest, com.windy.codepractice.grpclib.ContractOuterClass.ContractReply> getSayDaimlerMethod;
    if ((getSayDaimlerMethod = ContractGrpc.getSayDaimlerMethod) == null) {
      synchronized (ContractGrpc.class) {
        if ((getSayDaimlerMethod = ContractGrpc.getSayDaimlerMethod) == null) {
          ContractGrpc.getSayDaimlerMethod = getSayDaimlerMethod = 
              io.grpc.MethodDescriptor.<com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest, com.windy.codepractice.grpclib.ContractOuterClass.ContractReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Contract", "SayDaimler"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.windy.codepractice.grpclib.ContractOuterClass.ContractReply.getDefaultInstance()))
                  .setSchemaDescriptor(new ContractMethodDescriptorSupplier("SayDaimler"))
                  .build();
          }
        }
     }
     return getSayDaimlerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ContractStub newStub(io.grpc.Channel channel) {
    return new ContractStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContractBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ContractBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ContractFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ContractFutureStub(channel);
  }

  /**
   * <pre>
   * The Daimler service definition.
   * </pre>
   */
  public static abstract class ContractImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayDaimler(com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest request,
        io.grpc.stub.StreamObserver<com.windy.codepractice.grpclib.ContractOuterClass.ContractReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayDaimlerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayDaimlerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest,
                com.windy.codepractice.grpclib.ContractOuterClass.ContractReply>(
                  this, METHODID_SAY_DAIMLER)))
          .build();
    }
  }

  /**
   * <pre>
   * The Daimler service definition.
   * </pre>
   */
  public static final class ContractStub extends io.grpc.stub.AbstractStub<ContractStub> {
    private ContractStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContractStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContractStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ContractStub(channel, callOptions);
    }

    /**
     */
    public void sayDaimler(com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest request,
        io.grpc.stub.StreamObserver<com.windy.codepractice.grpclib.ContractOuterClass.ContractReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayDaimlerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Daimler service definition.
   * </pre>
   */
  public static final class ContractBlockingStub extends io.grpc.stub.AbstractStub<ContractBlockingStub> {
    private ContractBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContractBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContractBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ContractBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.windy.codepractice.grpclib.ContractOuterClass.ContractReply sayDaimler(com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayDaimlerMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Daimler service definition.
   * </pre>
   */
  public static final class ContractFutureStub extends io.grpc.stub.AbstractStub<ContractFutureStub> {
    private ContractFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContractFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContractFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ContractFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.windy.codepractice.grpclib.ContractOuterClass.ContractReply> sayDaimler(
        com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayDaimlerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_DAIMLER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ContractImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ContractImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_DAIMLER:
          serviceImpl.sayDaimler((com.windy.codepractice.grpclib.ContractOuterClass.ContractRequest) request,
              (io.grpc.stub.StreamObserver<com.windy.codepractice.grpclib.ContractOuterClass.ContractReply>) responseObserver);
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

  private static abstract class ContractBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContractBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.windy.codepractice.grpclib.ContractOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Contract");
    }
  }

  private static final class ContractFileDescriptorSupplier
      extends ContractBaseDescriptorSupplier {
    ContractFileDescriptorSupplier() {}
  }

  private static final class ContractMethodDescriptorSupplier
      extends ContractBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ContractMethodDescriptorSupplier(String methodName) {
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
      synchronized (ContractGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ContractFileDescriptorSupplier())
              .addMethod(getSayDaimlerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
