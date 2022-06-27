package net.nanthrax.samples.camel.http.pooling;

import org.apache.camel.builder.RouteBuilder;

public class HttpPoolingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:http-pooling")
                .log("Calling http pooling endpint")
                // default setup, one pool per camel context
                .to("http://localhost:8080/mock?connectionsPerRoute=20&maxTotalConnections=200")
                // we can share a clientConnectionManager across several contexts
                // .to("http://localhost:8080/mock?clientConnectionManager=#myConnectionManager")
                .to("log:http");
    }

}
