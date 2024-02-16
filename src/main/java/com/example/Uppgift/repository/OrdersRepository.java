package com.example.Uppgift.repository;

import com.example.Uppgift.models.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrdersRepository extends MongoRepository<Orders, String> {
    List<Orders> findByBooksIn(List<Orders> books);
}
