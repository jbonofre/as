package net.nanthrax.samples.camel.http.pooling;

import org.apache.camel.builder.RouteBuilder;

public class HttpPoolingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:http-pooling")
                .log("Calling http pooling endpint")
                .to("http://localhost:8080/mock")
                .to("log:http");
    }

}
