package com.events.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("1234")) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("booking.html");

        } else {

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Failed</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Login Failed</h1>");
            out.println("<p>Invalid username or password.</p>");
            out.println("<a href=\"login.html\">Try Again</a>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}
