package com.vtapps.quickstart.services;

import com.vtapps.quickstart.Domain.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookEntity save(String isbn, BookEntity book);

    List<BookEntity> findAll();

    Page<BookEntity> findAll(Pageable pageable);

    Optional<BookEntity> findById(String isbn);

    boolean isExists(String isbn);

    BookEntity partialUpdate(String isbn, BookEntity bookEntity);

    void delete(String isbn);
}
