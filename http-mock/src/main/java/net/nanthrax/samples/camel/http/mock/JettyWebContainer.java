package net.nanthrax.samples.camel.http.mock;

import jakarta.servlet.Servlet;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class JettyWebContainer {

    public void start() throws Exception {
        QueuedThreadPool threadPool = new QueuedThreadPool(100, 10, 60000);
        threadPool.setName("camel-sample-http-mock");
        Server server = new Server(threadPool);

        ServerConnector serverConnector = new ServerConnector(server, 1, 1, new HttpConnectionFactory());
        serverConnector.setPort(8080);
        serverConnector.setHost("0.0.0.0");
        serverConnector.setAcceptQueueSize(1);

        server.addConnector(serverConnector);

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);

        Servlet servlet = new MockServlet();
        servletContextHandler.addServlet(servlet.getClass(), "/mock");

        server.start();
    }

}
