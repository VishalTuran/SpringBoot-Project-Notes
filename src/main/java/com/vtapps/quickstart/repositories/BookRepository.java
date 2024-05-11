package com.vtapps.quickstart.repositories;

import com.vtapps.quickstart.Domain.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends CrudRepository<BookEntity,String>, PagingAndSortingRepository<BookEntity,String> {

}
