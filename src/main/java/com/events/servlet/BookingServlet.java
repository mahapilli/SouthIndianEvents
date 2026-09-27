package com.events.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        // Check whether user is logged in
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
            return;
        }

        // If logged in, open booking form
        response.sendRedirect("booking.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        // Check whether user is logged in
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
            return;
        }

        // Get booking details
        String customerName = request.getParameter("customerName");
        String eventType = request.getParameter("eventType");
        String eventDate = request.getParameter("eventDate");
        String location = request.getParameter("location");
        String decoration = request.getParameter("decoration");

        // MySQL connection details
        String url = "jdbc:mysql://localhost:3306/SouthIndianEvents?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "";

        // SQL query
        String sql = "INSERT INTO bookings " +
                "(customer_name, event_type, event_date, location, decoration) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {

            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            try (Connection con = DriverManager.getConnection(url, username, password);
                 PreparedStatement ps = con.prepareStatement(sql)) {

                // Set values
                ps.setString(1, customerName);
                ps.setString(2, eventType);
                ps.setString(3, eventDate);
                ps.setString(4, location);
                ps.setString(5, decoration);

                // Execute query
                ps.executeUpdate();
            }

        } catch (ClassNotFoundException e) {

            throw new IOException("MySQL Driver not found.", e);

        } catch (SQLException e) {

            throw new IOException("Database error: " + e.getMessage(), e);
        }

        // Booking confirmation page
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");

        out.println("<head>");
        out.println("<title>Booking Confirmation</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Booking Received</h1>");

        out.println("<p>Thank you, " + customerName + ".</p>");

        out.println("<p>Event Type: " + eventType + "</p>");

        out.println("<p>Event Date: " + eventDate + "</p>");

        out.println("<p>Location: " + location + "</p>");

        out.println("<p>Decoration: " + decoration + "</p>");

        out.println("<h2>Your booking has been saved successfully.</h2>");

        // Feedback link
        out.println("<br>");
        out.println("<a href=\"feedback.html\">Give Your Feedback</a>");

        // Home link
        out.println("<br><br>");
        out.println("<a href=\"index.html\">Back to Home</a>");

        out.println("</body>");

        out.println("</html>");
    }
}
