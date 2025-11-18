package com.ra.session12.repository;

import com.ra.session12.model.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Book> books = session.createQuery("from Book",Book.class).getResultList();
            session.getTransaction().commit();
            return books;
        }catch (Exception e) {
            return null;
        }
    }

    public Book findById(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Book book = session.createQuery("from Book where id = :id", Book.class).setParameter("id", id).getSingleResult();
            session.getTransaction().commit();
            return book;
        }catch (Exception e) {
            return null;
        }
    }

    public Book save(Book book) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Book newBook = (Book) session.merge(book);
            session.getTransaction().commit();
            return newBook;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
