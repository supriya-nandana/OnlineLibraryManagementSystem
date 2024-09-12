package com.example.librarySystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
   public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int bookId;
    private String bookTitle;
    private String authorName;
    private String bookDescription;
    private String categoryName;
    private int no_of_copies;
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getBookDescription() {
        return bookDescription;
    }
    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public int getNo_of_copies() {
        return no_of_copies;
    }
    public void setNo_of_copies(int no_of_copies) {
        this.no_of_copies = no_of_copies;
    }
   
  

}
