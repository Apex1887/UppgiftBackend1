package com.example.Uppgift.controllers;

import com.example.Uppgift.models.Books;
import com.example.Uppgift.models.Orders;
import com.example.Uppgift.models.Users;
import com.example.Uppgift.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @PostMapping
    public ResponseEntity<Orders> createOrders(@RequestBody Orders orders) {
        Orders createdOrders = ordersService.createOrders(orders);
        return new ResponseEntity<>(createdOrders, HttpStatus.CREATED);//ResponseEntity.status(HttpStatus.CREATED).body(createdOrders);
    }

    @GetMapping("/all")
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable String id) {
        Optional<Orders> orders = ordersService.getOrdersById(id);
        return orders.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrders(@PathVariable String id, @RequestBody Orders ordersDetails) {
        Orders updatedOrders = ordersService.updateOrders(id, ordersDetails);
        return ResponseEntity.ok(updatedOrders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrders(@PathVariable String id) {
        ordersService.deleteOrders(id);
        return ResponseEntity.ok("Orders with id: " + id + " has been deleted!");
    }

    @GetMapping("/search")
    public List<Orders> findOrdersByBooks(@RequestParam List<Orders> books) {
        return ordersService.findOrdersByBooks(books);
    }

    @PutMapping("/{id}/books")
    public ResponseEntity<Orders> addBookToOrders(@PathVariable String id, @RequestBody Books books) {
        Orders updatedOrders = ordersService.addBookToOrders(id, books);
        return ResponseEntity.ok(updatedOrders);
    }

    @PutMapping("/{id}/users")
    public ResponseEntity<Orders> addUserToOrders(@PathVariable String id, @RequestBody Users users) {
        Orders updatedOrders = ordersService.addUsersToOrders(id, users);
        return ResponseEntity.ok(updatedOrders);
    }

}