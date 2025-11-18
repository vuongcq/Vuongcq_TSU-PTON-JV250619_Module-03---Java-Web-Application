package com.ra.session12.service;

import com.ra.session12.model.dto.BookDTO;
import com.ra.session12.model.entity.Book;
import com.ra.session12.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @Transactional
    public Book save(BookDTO bookDTO){
        Book book= convertBookDTOToBook(bookDTO);
        if(bookDTO.getImage()!=null && !bookDTO.getImage().isEmpty()){
            String urlImage = cloudinaryService.upload(bookDTO.getImage());
            book.setImage(urlImage);
        }
        return bookRepository.save(book);
    }

    @Transactional
    public Book findBookById(long id){
        return bookRepository.findById(id);
    }

    @Transactional
    public Book updateBook(BookDTO bookDTO,long id){
        Book oldBook = findBookById(id);
        Book newBook = convertBookDTOToBook(bookDTO);
        newBook.setId(id);
        if(bookDTO.getImage()!=null && !bookDTO.getImage().isEmpty()){
            String urlImage = cloudinaryService.upload(bookDTO.getImage());
            newBook.setImage(urlImage);
        }else {
            newBook.setImage(oldBook.getImage());
        }
        return bookRepository.save(newBook);
    }

    public Book convertBookDTOToBook(BookDTO bookDTO){
        return Book
                .builder()
                .title(bookDTO.getTitle())
                .author(bookDTO.getAuthor())
                .price(bookDTO.getPrice())
                .publishYear(bookDTO.getPublishYear())
                .build();
    }

    public BookDTO convertBookToBookDTO(Book book){
        return BookDTO
                .builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .publishYear(book.getPublishYear())
                .build();
    }
}
