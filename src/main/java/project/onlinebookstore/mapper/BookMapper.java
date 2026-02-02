package project.onlinebookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.onlinebookstore.dto.book.BookDto;
import project.onlinebookstore.dto.book.BookRequestDto;
import project.onlinebookstore.entity.Book;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BookMapper {

        @Mapping(target = "categoryName", source = "category.name")
        BookDto mapToDto(Book book);


          default Book mapToEntity(BookRequestDto bookRequestDto){
            Book book = new Book();
            book.setTitle(bookRequestDto.getTitle());
            book.setAuthor(bookRequestDto.getAuthor());
            book.setPrice(bookRequestDto.getPrice());
              book.setQuantity(bookRequestDto.getQuantity());
            return book;
        }

    }
