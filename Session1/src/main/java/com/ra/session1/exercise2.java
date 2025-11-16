package com.ra.session1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class exercise2 {
    @WebServlet(name = "exercise2", value = "/exercise2")
    public static class Exercise2 extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // tạo dl
            int id = 1;
            String name = "Huấn";
            String email = "huanrose@gmail.com";
            int age = 18;

            // lưu dữ liệu vào request để gửi sang JSP
            request.setAttribute("id", id);
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("age", age);

            // chuyển tiếp sang JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("exercise2.jsp");
            dispatcher.forward(request, response);
        }
    }
}
