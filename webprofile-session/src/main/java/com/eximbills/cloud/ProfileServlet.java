package com.eximbills.cloud;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static Logger log = LoggerFactory.getLogger(ProfileServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        log.info("Into ProfileServlet");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        request.getRequestDispatcher("link.html").include(request, response);
        if (session != null && request.isRequestedSessionIdValid()) {
            log.info("The login name is " + session.getAttribute("name"));
            String name = (String) session.getAttribute("name");
            out.println("Hello, " + name + " Welcome to Profile");
            InetAddress ip = InetAddress.getLocalHost();
            log.info("The Host IP is " + ip);
            out.println("Host IP: " + ip.toString());
        } else {
            log.info("Not login yet");
            out.print("Please login first");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}