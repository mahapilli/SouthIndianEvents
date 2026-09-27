package com.events.servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class FeedbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.sendRedirect("feedback.html");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String rating = request.getParameter("rating");
        String review = request.getParameter("review");
        String url = "jdbc:mysql://localhost:3306/SouthIndianEvents?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "";
        String sql = "INSERT INTO feedback (name, rating, review) VALUES (?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, username, password);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setInt(2, Integer.parseInt(rating));
                ps.setString(3, review);
                ps.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            throw new IOException("MySQL Driver not found.", e);
        } catch (SQLException e) {
            throw new IOException("Database error: " + e.getMessage(), e);
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Feedback</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Feedback Submitted</h1>");
        out.println("<p>Thank you, " + name + ".</p>");
        out.println("<p>Your feedback has been submitted successfully.</p>");
        out.println("<br>");
        out.println("<a href=\"index.html\">Back to Home</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
