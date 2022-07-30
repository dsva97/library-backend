package com.darwin.library.controller;

import com.darwin.library.exception.ModelNotFoundException;
import com.darwin.library.model.Book;
import com.darwin.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
    }

    @PutMapping
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") Integer idBook) {
        Book book = bookService.findById(idBook);

        if(book == null ) {
            throw new ModelNotFoundException("El libro que desea eliminar no existe");
        }

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idBook) {
        Book book = bookService.findById(idBook);

        if(book == null ) {
            throw new ModelNotFoundException("El libro que desea eliminar no existe");
        }
        bookService.delete(idBook);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
