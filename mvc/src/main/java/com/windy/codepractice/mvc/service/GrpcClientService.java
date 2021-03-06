package com.windy.codepractice.mvc.service;

import com.windy.codepractice.grpclib.ContractGrpc;
import com.windy.codepractice.grpclib.ContractOuterClass;
import com.windy.codepractice.grpclib.EntityDemoGrpc;
import com.windy.codepractice.grpclib.EntityOuterClass;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("local-grpc-server")
    private Channel serverChannel;

    public String sendMessage(String name) {

        ContractGrpc.ContractBlockingStub stub = ContractGrpc.newBlockingStub(serverChannel);
        ContractOuterClass.ContractReply response =stub.sayDaimler(ContractOuterClass.ContractRequest.newBuilder().setContraId(name).build());
        return response.getMessage();
    }

    public Object entityByName(String name) {

        EntityDemoGrpc.EntityDemoBlockingStub stub = EntityDemoGrpc.newBlockingStub(serverChannel);
        EntityOuterClass.EntityReply response =stub.entityByName(EntityOuterClass.EntityRep.newBuilder().setUserName(name).build());
        return response;
    }

}
