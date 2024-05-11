package com.vtapps.quickstart.mappers.impl;

import com.vtapps.quickstart.Domain.dto.BookDto;
import com.vtapps.quickstart.Domain.entities.BookEntity;
import com.vtapps.quickstart.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<BookEntity, BookDto> {
    private ModelMapper modelMapper;

    public BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto mapTo(BookEntity bookEntity) {
        return modelMapper.map(bookEntity,BookDto.class);
    }

    @Override
    public BookEntity mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto,BookEntity.class);
    }
}
