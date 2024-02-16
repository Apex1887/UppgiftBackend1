package com.example.Uppgift.controllers;

import com.example.Uppgift.models.Books;
import com.example.Uppgift.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BooksService bookService;

    @PostMapping
    public ResponseEntity<Books> addBooks(@RequestBody Books books) {
        Books savedBooks = bookService.addBooks(books);
        return new ResponseEntity<>(savedBooks, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks() {
        List<Books> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Books> getBooksById(@PathVariable String id) {
        return bookService.getBooksById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable String id, @RequestBody Books books) {
        Books updatedBook = bookService.updateBooks(id, books);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Books> deleteBook(@PathVariable String id) {
        bookService.deleteBooks(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


