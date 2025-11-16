package com.ra.session1;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "exciser1", value = "/exercise1")
public class exercise1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        request.setAttribute("time", LocalDateTime.now().format(dtf));
        request.getRequestDispatcher("exercise1.jsp").forward(request,response);
    }
}