package com.vtapps.quickstart.controllers;

import com.vtapps.quickstart.Domain.entities.AuthorEntity;
import com.vtapps.quickstart.Domain.dto.AuthorDto;
import com.vtapps.quickstart.mappers.Mapper;
import com.vtapps.quickstart.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AuthorController {
    private AuthorService authorService;
    private Mapper<AuthorEntity, AuthorDto> authorMapper;


    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto author) {
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }

    @GetMapping(path= "/authors")
    public List<AuthorDto> listAuthor(){
      List<AuthorEntity> authors=authorService.findAll();
      return authors.stream().map(authorMapper::mapTo)
              .collect(Collectors.toList());
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> findAuthorWithId(@PathVariable("id") Long id){
        Optional<AuthorEntity> foundAuthor=authorService.findById(id);
        return foundAuthor.map(authorEntity -> {
            AuthorDto authorDto=authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> fullUpdateAuthor(@PathVariable("id") Long id,@RequestBody AuthorDto author) {
        if(!authorService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        author.setId(id);
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }

    @PatchMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> partialUpdateAuthor(@PathVariable("id") Long id,@RequestBody AuthorDto author) {
        if(!authorService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.partialUpdate(id,authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.OK);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id") Long id) {
        if(!authorService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        authorService.delete(id);
        return new ResponseEntity<>("Success", HttpStatus.NO_CONTENT);
    }

}
