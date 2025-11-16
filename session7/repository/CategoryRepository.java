package com.ra.session7.repository;

import com.ra.session7.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.From;
import java.util.List;

@Repository
public class CategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Category> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category", Category.class).list();
    }

    public Category findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.get(Category.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean save(Category category) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.saveOrUpdate(category);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean exístsByCateName(String cateName) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Category category = session.createQuery("from Category where cateName = :cateName", Category.class)
                    .setParameter("cateName", cateName).getSingleResult();
            return category != null;
        } catch (NoResultException e) {
            return false;
        }
    }
}
