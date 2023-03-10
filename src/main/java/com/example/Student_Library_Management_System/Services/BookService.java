package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final AuthorRepository authorRepository;

    public BookService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public String addBook(BookRequestDto bookRequestDto){


        //I want to get the AuthorEntity ??
        int authorId = bookRequestDto.getAuthorId();

        //now i willl be fetching the authorEntity

        Author author = authorRepository.findById(authorId).get();

        //We have created this Entity so that we can save it into the DB
        Book book = new Book();

        //Basic attrubute are being from Dto to the Entity Layer
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());

        //Setting the foreign key attrubuite in the hcild class
        book.setAuthor(author);

        //we need to update the listofBooks written in the parent class

        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);

        author.setBooksWritten(currentBooksWritten);


        //Now the book is to be sasved, but also authoris also to be saved
        //why do we need to again save updating the author ?? because
        //because the author Entity has been updated..we need to resave/update it

        authorRepository.save(author);  //Date was modified

        //save funcion works both as save funcion and as update function
        //boookRepo.save is not required : bcz it will be autocalled by cascading

        return "Book Added successfully";
    }
}
