package net.nanthrax.samples.camel.geocluster;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class GeoMichiganServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Michigan</title></head><body>");

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        writer.println("<h2>Hello from Michigan!</h2><br/>");
        writer.println("It's " + new Date().toString());
        writer.println("</body></html>");
        writer.flush();
        writer.close();
    }

}
