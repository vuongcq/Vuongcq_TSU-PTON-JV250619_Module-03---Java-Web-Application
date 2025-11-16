package com.ra.session1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class exercise3 {
    @WebServlet (name = "exercise3", value = "/exercise3")
    public static class Exercise3 extends HttpServlet {
       private final List<Customer> customers = new ArrayList<Customer>();
       public void init() throws ServletException {
           customers.add(new Customer(1,"Nguyễn Văn A", LocalDate.of(1983,8,20),"Hà Nội","https://www.bom.edu.vn/upload/2025/03/anh-dai-dien-dep-cho-nu-anime-9.webp"));
           customers.add(new Customer(2,"Đào Văn B", LocalDate.of(1999,2,11),"Hà Nội","https://www.bom.edu.vn/upload/2025/03/anh-dai-dien-dep-cho-nu-anime-4.webp"));
           customers.add(new Customer(3,"Phạm Thị C", LocalDate.of(1995,4,25),"Hà Nội","https://www.bom.edu.vn/upload/2025/03/anh-dai-dien-dep-cho-nu-anime-6.webp"));
           customers.add(new Customer(4,"Bàng Trọng D", LocalDate.of(1985,1,12),"Hà Nội","https://www.bom.edu.vn/upload/2025/03/anh-dai-dien-dep-cho-nu-anime-7.webp"));
           customers.add(new Customer(5,"Nguyễn Xuân E", LocalDate.of(1998,7,22),"Hà Nội","https://www.bom.edu.vn/upload/2025/03/anh-dai-dien-dep-cho-nu-anime-9.webp"));
       }

       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setAttribute("customers", customers);
           request.getRequestDispatcher("exercise3.jsp").forward(request, response);
       }
    }
}
