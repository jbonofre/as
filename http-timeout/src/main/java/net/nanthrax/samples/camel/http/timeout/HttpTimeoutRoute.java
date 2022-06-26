package net.nanthrax.samples.camel.http.timeout;

import org.apache.camel.builder.RouteBuilder;

public class HttpTimeoutRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:http-timeout")
                .to("http://localhost:8080/mock?socketTimeout=1000")
                .log("Exception expected in the exchange here, can be catched by error hander");
    }

}
