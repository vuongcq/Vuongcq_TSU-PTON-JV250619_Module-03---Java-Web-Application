package re.com.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import re.com.model.Categories;
import re.com.repository.CategoriesRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CategoriesRepositoyImp implements CategoriesRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Categories> findALl() {
        // Dùng EntityManager để chạy truy vấn JPQL Lấy toàn bộ danh sách các bản ghi trong bảng Category
        // (là danh sách tất cả các đối tượng Category trong database)
        // và trả về dưới dạng danh sách các đối tượng (List<Category>)
        return entityManager.createQuery("from Categories c", Categories.class).getResultList();
    }

    @Override
    public List<Categories> findByPage(int page,int size) {
        String hql = "from Categories";
        TypedQuery<Categories> query = entityManager.createQuery(hql, Categories.class);
        //Lấy dữ liệu đầu tiên từ chỉ số nào (offset)
        query.setFirstResult((page - 1) * size);//chỉ số dữ liệu bắt đầu
        //limit
        query.setMaxResults(size);//Lấy SIZE dữ liệu
        return query.getResultList();
    }

    @Override
    public Categories findById(int catalogId) {
        return entityManager.createQuery("from Categories where catalogId = :id", Categories.class)
                .setParameter("id", catalogId).getSingleResult();
    }

    @Override
    //Khi thêm, sửa, xóa bắt buộc phải quản lý transaction (Spring)
    @Transactional
    public boolean save(Categories catalog) {
        try {
            entityManager.persist(catalog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Categories catalog) {
        try {
            entityManager.merge(catalog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int catalogId) {
        try {
            Categories catalog = findById(catalogId);
            entityManager.remove(catalog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
