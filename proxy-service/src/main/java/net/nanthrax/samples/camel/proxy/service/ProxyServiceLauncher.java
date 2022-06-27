package net.nanthrax.samples.camel.proxy.service;

import org.apache.camel.impl.DefaultCamelContext;

public class ProxyServiceLauncher {

    public void start() throws Exception {
        DefaultCamelContext camelContext = new DefaultCamelContext();
        camelContext.setAutoStartup(false);
        camelContext.addRoutes(new ProxyServiceRoute());
        camelContext.start();
    }

}
