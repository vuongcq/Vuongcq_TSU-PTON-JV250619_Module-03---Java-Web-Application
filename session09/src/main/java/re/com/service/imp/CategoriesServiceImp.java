package re.com.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.com.model.Categories;
import re.com.repository.CategoriesRepository;
import re.com.service.CategoriesService;

import java.util.List;

@Service
public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findALl();
    }

    @Override
    public List<Categories> findByPage(int page, int size) {
        return categoriesRepository.findByPage(page, size);
    }

    @Override
    public Categories findById(int catalogId) {
        return categoriesRepository.findById(catalogId);
    }

    @Override
    public boolean create(Categories catalog) {
        return categoriesRepository.save(catalog);
    }

    @Override
    public boolean update(Categories catalog) {
        return categoriesRepository.update(catalog);
    }

    @Override
    public boolean delete(int catalogId) {
        return categoriesRepository.delete(catalogId);
    }
}
