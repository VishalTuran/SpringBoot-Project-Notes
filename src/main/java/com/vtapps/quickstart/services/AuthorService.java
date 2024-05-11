package com.vtapps.quickstart.services;

import com.vtapps.quickstart.Domain.entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorEntity save(AuthorEntity authorEntity);

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findById(Long id);

    boolean isExists(Long id);

    AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);

    void delete(Long id);
}
