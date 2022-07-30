package com.darwin.library.service;

import com.darwin.library.model.Book;

import java.util.List;

public interface IBookService {
    Book create(Book book);
    Book update(Book book);
    Book findById(Integer id);
    List<Book> findAll();
    void delete(Integer id);
}
