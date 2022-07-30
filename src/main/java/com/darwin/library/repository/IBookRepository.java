package com.darwin.library.repository;

import com.darwin.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
