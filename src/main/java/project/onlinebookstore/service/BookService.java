package project.onlinebookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onlinebookstore.dto.book.BookDto;
import project.onlinebookstore.dto.book.BookRequestDto;
import project.onlinebookstore.entity.Book;
import project.onlinebookstore.entity.Category;
import project.onlinebookstore.exception.BusinessException;
import project.onlinebookstore.exception.NotFoundException;
import project.onlinebookstore.mapper.BookMapper;
import project.onlinebookstore.repository.BookRepository;
import project.onlinebookstore.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {


    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CategoryRepository categoryRepository;

    public BookDto save(BookRequestDto requestDto) {
        if (requestDto.getPrice() <= 0) {
            throw new BusinessException("Price must be greater than 0");
        }

        Category category = categoryRepository.findById(requestDto.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Category not found"));
        Book book = bookMapper.mapToEntity(requestDto);
        book.setCategory(category);
        return bookMapper.mapToDto(bookRepository.save(book));
    }

    public BookDto getBooksById(Long id) {
        Book books = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found"));
        return bookMapper.mapToDto(books);
    }

    public List<BookDto> getAllBooks() {
       return bookRepository.findAll()
                .stream()
                .map(bookMapper::mapToDto)
                .toList();
    }


        public void deleteBookById(Long id) {
            if (!bookRepository.existsById(id)) {
                throw new NotFoundException("Book not found");
            }
            bookRepository.deleteById(id);
        }
}
