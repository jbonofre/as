package net.nanthrax.samples.camel.http.mock;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class MockServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Mock</title></head><body>");
        writer.println("<h2>Hello World!</h2><br/>");
        writer.println("It's " + new Date().toString());
        writer.println("</body></html>");
        writer.flush();
        writer.close();
    }

}
