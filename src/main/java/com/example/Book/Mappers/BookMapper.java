package com.example.Book.Mappers;

import com.example.Book.Dto.BookDto;
import com.example.Book.Entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
     BookMapper mapper = Mappers.getMapper(BookMapper.class) ;

        BookDto bookToBookDTO(Book book);

        Book booktDtoToBook(BookDto bookDto);
    }

