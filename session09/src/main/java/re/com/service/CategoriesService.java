package re.com.service;

import re.com.model.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();

    List<Categories> findByPage(int page, int size);

    Categories findById(int catalogId);

    boolean create(Categories catalog);

    boolean update(Categories catalog);

    boolean delete(int catalogId);
}
