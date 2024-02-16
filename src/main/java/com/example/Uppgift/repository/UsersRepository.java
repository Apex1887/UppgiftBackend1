package com.example.Uppgift.repository;

import com.example.Uppgift.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {
}
