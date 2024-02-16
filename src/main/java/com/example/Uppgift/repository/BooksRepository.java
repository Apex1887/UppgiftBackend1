package com.example.Uppgift.repository;

import com.example.Uppgift.models.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BooksRepository extends MongoRepository<Books, String> {

}
