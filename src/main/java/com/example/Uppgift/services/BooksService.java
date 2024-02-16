package com.example.Uppgift.services;

import com.example.Uppgift.models.Books;
import com.example.Uppgift.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    BooksRepository booksRepository;

    public Books addBooks(Books books){
        return booksRepository.save(books);
    }

    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    public Books updateBooks(String id, Books books) {
        return booksRepository.save(books);
    }

    public Optional<Books> getBooksById(String id) {
        return Optional.of(booksRepository.findById(id).get());
    }

    public String deleteBooks(String id) {
        booksRepository.deleteById(id);
        return "Book deleted";
    }

}
