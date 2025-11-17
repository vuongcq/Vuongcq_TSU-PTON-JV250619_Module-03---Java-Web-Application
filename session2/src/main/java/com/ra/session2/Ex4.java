package com.ra.session2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ex4", urlPatterns = {"/ex4", "/ex4/add", "/ex4/delete"})
public class Ex4 extends HttpServlet {
    private final List<Product> products = new ArrayList<Product>();

    @Override
    public void init() throws ServletException {
        products.add(new Product(1, "Gạo Lứt", "Mô tả gạo lứt", 20000, "https://login.medlatec.vn//ImagePath/images/20211127/20211127_gao-lut-co-tot-khong-2.png"));
        products.add(new Product(2, "Lạc Rang", "Mô tả lạc rang", 5000, "https://danviet.ex-cdn.com/files/f1/296231569849192448/2022/8/5/lac-rang-muoi-1659687349531461745645.jpeg"));
        products.add(new Product(3, "Muối Vừng", "Mô tả muối vừng", 50000, "https://cf.shopee.vn/file/85a100e6c30d8fa0535802b12f179cb1"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        // Hiển thị form thêm mới
        if (uri.endsWith("/add")) {
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
            return;
        }

        // Xóa sản phẩm
        if (uri.endsWith("/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));

            products.removeIf(p -> p.getId() == id);

            resp.sendRedirect(req.getContextPath() + "/ex4");
            return;
        }
        req.setAttribute("products", products);
        req.getRequestDispatcher("ex4.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        // Nhận dữ liệu form thêm mới
        if (uri.endsWith("/add")) {
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            int price = Integer.parseInt(req.getParameter("price"));
            String image = req.getParameter("image");

            int id = products.size() + 1;

            products.add(new Product(id, name, description, price, image));

            // Quay về danh sách
            resp.sendRedirect(req.getContextPath() + "/ex4");
        }
    }
}
