package com.example.Uppgift.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Books")
public class Books {

    @Id
    private String id;

    private String BookName;

    private String Author;

    @CreatedDate
    private Date created_at;

    public Books(String id) {
        this.id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public String getAuthor() {
        return Author;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
