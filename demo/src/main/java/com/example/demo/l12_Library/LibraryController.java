package com.example.demo.l12_Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/l12/library")
public class LibraryController {

    private final  LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<LibraryDTO> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @PostMapping
    public LibraryDTO addBook(@RequestBody LibraryDTO libraryDTO) {
        return libraryService.addBook(libraryDTO);
    }
}
