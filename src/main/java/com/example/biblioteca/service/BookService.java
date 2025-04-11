package com.example.biblioteca.service;

//Primero el modelo
import com.example.biblioteca.model.Book;
import com.example.biblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
//Indicamos que es un service
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks(){
        return bookRepository.getBooks();
    }
    
    public Book getBookById(int id){
        return bookRepository.getBookForId(id);
    }

    public Book getBookByIsbn(String isbn){
        return bookRepository.getBookForIsbn(isbn);
    }

    public Book getBookByAutor(String autor){
        return bookRepository.getBookForAuthor(autor);
    }

    public Book saveBooks(Book book){
        return bookRepository.saveBook(book);
    }

    public Book updateBook(Book book){
        return bookRepository.updateBook(book);
    }

    public String deleteBook(int id){
        bookRepository.deleteBook(id);
        return "Book deleted successfull";
    }

    public int totalBooks(){
        return bookRepository.totalBooks();
    }
}
