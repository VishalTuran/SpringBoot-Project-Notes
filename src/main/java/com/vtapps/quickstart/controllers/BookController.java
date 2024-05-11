package com.vtapps.quickstart.controllers;

import com.vtapps.quickstart.Domain.dto.BookDto;
import com.vtapps.quickstart.Domain.entities.BookEntity;
import com.vtapps.quickstart.mappers.Mapper;
import com.vtapps.quickstart.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private BookService bookService;
    private Mapper<BookEntity, BookDto> bookMapper;

    public BookController(BookService bookService,Mapper<BookEntity, BookDto> bookMapper){
        this.bookService=bookService;
        this.bookMapper=bookMapper;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createUpdateBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto){
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        boolean bookExists=bookService.isExists(isbn);
        BookEntity savedBookEntity = bookService.save(isbn, bookEntity);
        BookDto savedBookDto=bookMapper.mapTo(savedBookEntity);
        if(bookExists){
            return new ResponseEntity<>(savedBookDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(savedBookDto,HttpStatus.CREATED);
        }
    }

    @PatchMapping("/books/{isbn}")
    public ResponseEntity<BookDto> partialUpdateBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto){
        boolean bookExists=bookService.isExists(isbn);
        if(!bookExists){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity savedBookEntity = bookService.partialUpdate(isbn, bookEntity);
        BookDto savedBookDto=bookMapper.mapTo(savedBookEntity);
        return new ResponseEntity<>(savedBookDto,HttpStatus.OK);
    }

    @GetMapping("/books")
    public Page<BookDto> findAll(Pageable pageable){
        Page<BookEntity> bookEntities=bookService.findAll(pageable);
        return bookEntities.map(bookMapper::mapTo);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<BookDto> findById(@PathVariable("isbn") String isbn){
        Optional<BookEntity> bookFound=bookService.findById(isbn);
        return bookFound.map(bookEntity->{
            BookDto bookDto=bookMapper.mapTo(bookEntity);
            return new ResponseEntity<>(bookDto,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable("isbn") String isbn) {
        if(!bookService.isExists(isbn)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookService.delete(isbn);
        return new ResponseEntity<>("Success", HttpStatus.NO_CONTENT);
    }


}
