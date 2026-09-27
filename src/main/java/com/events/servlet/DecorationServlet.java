package com.events.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DecorationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Decorations</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>South Indian Decorations</h1>");

        out.println("<h2>Our Decoration Services</h2>");

        out.println("<p>Wedding Decoration</p>");
        out.println("<p>Flower Decoration</p>");
        out.println("<p>Traditional Mandapam</p>");
        out.println("<p>Entrance Decoration</p>");
        out.println("<p>Stage Decoration</p>");

        out.println("<br>");
        out.println("<a href=\"index.html\">Back to Home</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
