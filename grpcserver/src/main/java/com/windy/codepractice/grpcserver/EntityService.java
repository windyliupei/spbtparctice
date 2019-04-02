package com.windy.codepractice.grpcserver;

import com.windy.codepractice.grpclib.EntityOuterClass;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

@GrpcService(com.windy.codepractice.grpclib.EntityOuterClass.class)
public class EntityService extends  com.windy.codepractice.grpclib.EntityDemoGrpc.EntityDemoImplBase{

    @Override
    public void entityByName(EntityOuterClass.EntityRep request, StreamObserver<EntityOuterClass.EntityReply> responseObserver) {
        //super.entityByName(request, responseObserver);
        final EntityOuterClass.EntityReply.Builder replyBuilder = EntityOuterClass.EntityReply.newBuilder()
                .setUserName(request.getUserName())
                .setAge(5)
                .setId(100L);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();

    }
}
