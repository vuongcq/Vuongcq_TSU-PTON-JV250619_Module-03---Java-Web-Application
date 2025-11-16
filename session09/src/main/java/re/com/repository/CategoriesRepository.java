package re.com.repository;

import re.com.model.Categories;

import java.util.List;

public interface CategoriesRepository {
    //Lấy tất danh mục --> tính được tổng số trang cần hiển thị
    List<Categories> findALl();
    //Lấy dữ liệu theo trang (limit offset)
    List<Categories> findByPage(int page, int size );

    Categories findById(int catalogId);

    boolean save(Categories catalog);

    boolean update(Categories catalog);

    boolean delete(int catalogId);
}
