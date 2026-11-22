package com.example.demo.l9;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/l9/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public BookEntity createBook(@RequestBody BookEntity book) {
        return bookRepository.save(book);
    };

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }
}
