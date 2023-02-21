package com.example.Student_Library_Management_System.Models;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int pages;

    @Enumerated(value = EnumType.STRING)
    private com.example.Student_Library_Management_System.Models.Genre genre;

    //Book is child  with respect to Author is parent class
    //Setting here the foreign key : Standard 3 steps
    @ManyToOne
    @JoinColumn //Add on extra attribute of authorId (parent table PK) for the foreign key of child table
    private Author author; // this is the parent entity we are connecting eith


    //Book is also child eithto card
    @ManyToOne
    @JoinColumn
    private Card card;


    private boolean issued;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public com.example.Student_Library_Management_System.Models.Genre getGenre() {
        return genre;
    }

    public void setGenre(com.example.Student_Library_Management_System.Models.Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
