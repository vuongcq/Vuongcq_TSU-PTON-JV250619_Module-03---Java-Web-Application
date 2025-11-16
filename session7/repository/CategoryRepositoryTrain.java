package com.ra.session7.repository;

import com.ra.session7.model.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryRepositoryTrain {
    @PersistenceContext
    private EntityManager entityManager;
    public List <Category> findAll() {
        // Dùng EntityManager để chạy truy vấn JPQL Lấy toàn bộ danh sách các bản ghi trong bảng Category
        // (là danh sách tất cả các đối tượng Category trong database)
        // và trả về dưới dạng danh sách các đối tượng (List<Category>)
        return entityManager.createQuery("from Category c", Category.class).getResultList();

    }
}
