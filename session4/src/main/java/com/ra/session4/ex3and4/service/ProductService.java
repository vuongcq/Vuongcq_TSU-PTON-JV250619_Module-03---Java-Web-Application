package com.ra.session4.ex3and4.service;

import com.ra.session4.ex3and4.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    public List<Product> getListProduct(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Khoai tây", 15000, 50, "Ngon"));
        products.add(new Product(2, "Cà rốt", 12000, 30, "Giòn"));
        products.add(new Product(3, "Hành tây", 20000, 40, "Ngọt"));
        products.add(new Product(4, "Ớt chuông", 25000, 20, "Thơm"));
        products.add(new Product(5, "Bắp cải", 18000, 35, "Tươi"));
        products.add(new Product(6, "Củ cải", 16000, 25, "Ngọt"));
        products.add(new Product(7, "Dưa leo", 14000, 45, "Mát"));
        products.add(new Product(8, "Cà chua", 22000, 60, "Chua"));
        products.add(new Product(9, "Rau diếp", 17000, 55, "Tươi"));
        products.add(new Product(10, "Khoai lang", 19000, 50, "Ngon"));
        return products;
    }
    public List<Product> searchProductsByName(String searchProductName){
        if (searchProductName==null || searchProductName.isEmpty()){
            return getListProduct();
        } else {
            List<Product> resultsList = new ArrayList<>();
            for(Product p: getListProduct()){
                if(p.getProductName().toLowerCase().contains(searchProductName.toLowerCase())){
                    resultsList.add(p);
                }
            }
            return resultsList;
        }
    }
}
