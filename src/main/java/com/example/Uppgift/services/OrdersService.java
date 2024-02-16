package com.example.Uppgift.services;

import com.example.Uppgift.EntityNotFoundException;
import com.example.Uppgift.models.Books;
import com.example.Uppgift.models.Orders;
import com.example.Uppgift.models.Users;
import com.example.Uppgift.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public Orders createOrders(Orders orders){
        return ordersRepository.save(orders);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }


    public Orders updateOrders(String id, Orders updatedOrders) {
        Orders existingOrders = ordersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with id: " + id + " was not found!"));

        existingOrders.setId(updatedOrders.getId());
        existingOrders.setBooks(updatedOrders.getBooks());
        existingOrders.setId(updatedOrders.getId());
        existingOrders.setCreated_at(updatedOrders.getCreated_at());
        existingOrders.setReturned_at(updatedOrders.getReturned_at());

        return ordersRepository.save(existingOrders);
    }


    public Optional<Orders> getOrdersById(String id) {
        return ordersRepository.findById(id);
    }


    public void deleteOrders(String id) {
        ordersRepository.deleteById(id);
    }

    public List<Orders> findOrdersByBooks(List<Orders> books) {
        return ordersRepository.findByBooksIn(books);
    }

    public Orders addBookToOrders(String order_Id, Books books) {
        Orders orders = ordersRepository.findById(order_Id)
                .orElseThrow(() -> new EntityNotFoundException("Order with id: " + order_Id + " was not found!"));

        orders.getBooks().add(books);
        return ordersRepository.save(orders);
    }

    public Orders addUsersToOrders(String Id, Users users) {
        Orders orders = ordersRepository.findById(Id)
                .orElseThrow(() -> new EntityNotFoundException("Order with id: " + Id + " was not found!"));

        orders.getUsersID().add(users);
        return ordersRepository.save(orders);
    }

}