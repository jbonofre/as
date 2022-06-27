package net.nanthrax.samples.camel.proxy.service;

import org.apache.camel.builder.RouteBuilder;

public class ProxyServiceRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:http-pooling")
                .log("Calling http pooling endpoint")
                .choice()
                .when(simple("${header.geo} == 'texas'")).to("http://localhost:8080/texas")
                .when(simple("${header.geo} == 'michigan'")).to("http://localhost:8080/michigan")
                .to("log:service-proxy");
    }

}
