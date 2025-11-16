package com.ra.session7.service;

import com.ra.session7.model.entity.Category;
import com.ra.session7.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    public boolean save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public boolean existsByCateName(String cateName) {
        return categoryRepository.exístsByCateName(cateName);
    }
}
