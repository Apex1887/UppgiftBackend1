package com.example.Uppgift.services;

import com.example.Uppgift.EntityNotFoundException;
import com.example.Uppgift.models.Users;
import com.example.Uppgift.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public Users createUsers(Users users){
        return usersRepository.save(users);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users updateUsers(String id, Users updatedUser) {
        Users existingUser = usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " was not found!"));

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setCreated_at(updatedUser.getCreated_at());

        return usersRepository.save(existingUser);
    }

    public Users getUsersById(String id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " was not found!"));
    }

    public void deleteUsers(String id) {
        usersRepository.deleteById(id);
    }
}