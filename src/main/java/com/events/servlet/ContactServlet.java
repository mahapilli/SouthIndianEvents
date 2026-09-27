package com.events.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Contact Us</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Contact Us</h1>");

        out.println("<p>South Indian Events & Decorations</p>");
        out.println("<p>Phone: 9876543210</p>");
        out.println("<p>Email: southindianevents@gmail.com</p>");
        out.println("<p>Location: Vijayawada</p>");

        out.println("<br>");
        out.println("<a href=\"index.html\">Back to Home</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
