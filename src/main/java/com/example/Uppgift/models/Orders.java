package com.example.Uppgift.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "orders")
public class Orders {

    @Id
    private String id;

    private List<Books> books;

    @DBRef
    private Users usersID;

    @CreatedDate
    private Date created_at;

    private Date returned_at;


    public Orders(String id, List<Books> books, Users usersID, Date created_at, Date returned_at) {
        this.id = id;
        this.books = books;
        this.usersID = usersID;
        this.created_at = created_at;
        this.returned_at = returned_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public Users getUsersID() {
        return usersID;
    }

    public void setUsersID(Users usersID) {
        this.usersID = usersID;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getReturned_at() {
        return returned_at;
    }

    public void setReturned_at(Date returned_at) {
        this.returned_at = returned_at;
    }
}
