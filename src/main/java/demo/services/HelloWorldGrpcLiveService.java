package demo.services;

import demo.grpc.ExampleGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class HelloWorldGrpcLiveService extends ExampleGrpc.ExampleImplBase {

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloWorldGrpcLiveService.class);

    private Process process;

    @Autowired
    public HelloWorldGrpcLiveService(final Process process) {
        this.process = process;
    }


}
