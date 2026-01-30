package project.onlinebookstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.onlinebookstore.dto.book.BookDto;
import project.onlinebookstore.dto.book.BookRequestDto;
import project.onlinebookstore.dto.book.UpdateBookRequestDto;
import project.onlinebookstore.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

            private final BookService bookService;

        @PostMapping("/save")
        public BookDto save(@RequestBody BookRequestDto createBooksRequestDto) {
            return bookService.save(createBooksRequestDto);
        }

        @GetMapping("/{id}")
        public BookDto getBooksById(@PathVariable Long id) {
            return bookService.getBooksById(id);
        }

        @GetMapping
        public List<BookDto> getAllBooks() {

            return bookService.getAllBooks();
        }

        @PutMapping("/{id}")
        public BookDto update(@PathVariable Long id, @RequestBody UpdateBookRequestDto updateBookRequestDto) {
            return bookService.getBooksById(id);
        }

        @DeleteMapping("/{id}")
        public BookDto delete(@PathVariable Long id) {
            return bookService.getBooksById(id);
        }
    }

