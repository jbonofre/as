package net.nanthrax.samples.camel.http.pooling;

import org.apache.camel.impl.DefaultCamelContext;

public class HttpPoolingLauncher {

    public void start() throws Exception {
        DefaultCamelContext camelContext = new DefaultCamelContext();
        camelContext.setAutoStartup(false);
        camelContext.addRoutes(new HttpPoolingRoute());
        camelContext.start();
    }

}
