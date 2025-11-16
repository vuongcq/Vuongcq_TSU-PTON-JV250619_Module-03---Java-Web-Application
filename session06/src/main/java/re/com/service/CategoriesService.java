package re.com.service;

import re.com.model.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();

    boolean create(Categories catalog);

    Categories findById(int catalogId);

    boolean update(Categories catalog);

    boolean delete(int catalogId);
}
