package com.windy.codepractice.grpcserver;


import com.windy.codepractice.grpclib.ContractGrpc;
import com.windy.codepractice.grpclib.ContractOuterClass;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;


@Slf4j
@GrpcService(ContractOuterClass.class)
public class ContractService extends ContractGrpc.ContractImplBase {

    @Override
    public void sayDaimler(ContractOuterClass.ContractRequest request, StreamObserver<ContractOuterClass.ContractReply> responseObserver) {
        //super.sayDaimler(request, responseObserver);
        String message = "Hi"+request.getContraId();
        final ContractOuterClass.ContractReply.Builder replyBuilder =ContractOuterClass.ContractReply.newBuilder().setMessage(message);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}
