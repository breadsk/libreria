package com.example.biblioteca.controller;

import com.example.biblioteca.model.Book;//Get my model
import com.example.biblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
    
    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBooks(book);
    }
    
    @GetMapping("{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
    
    @PutMapping("{id}")
    public Book updateBook(@PathVariable int id,@RequestBody Book book) {
        //El Id lo haremos mas adelante        
        return bookService.updateBook(book);
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable int id){
        return bookService.deleteBook(id);
    }
}
