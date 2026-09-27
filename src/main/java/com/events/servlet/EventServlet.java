package com.events.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EventServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Events</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>South Indian Events</h1>");

        out.println("<h2>Our Events</h2>");

        out.println("<p>Wedding</p>");
        out.println("<p>Engagement</p>");
        out.println("<p>Naming Ceremony</p>");
        out.println("<p>Housewarming</p>");
        out.println("<p>Baby Shower</p>");
        out.println("<p>Birthday</p>");

        out.println("<br>");
        out.println("<a href=\"index.html\">Back to Home</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
