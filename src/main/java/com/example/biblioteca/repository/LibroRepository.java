package com.example.biblioteca.repository;

import com.example.biblioteca.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //Especialización de la anotación @Component
//Se usa para anotar clases que acceden a la base de datos, encapsulan el
//almacenamiento, recuperación y búsqueda de objetos de dominio.

public class LibroRepository {

    //Arrangement that would keep all the books
    private List<Book> listBooks = new ArrayList<>();

    //Method to initialize dummy data

    @PostConstruct
    public void init(){
        listBooks.add(new Book(1, "978-0134685991", "Effective Java", "Addison-Wesley", 2018, "Joshua Bloch"));
        listBooks.add(new Book(2, "978-1617294945", "Spring in Action", "Manning", 2020, "Craig Walls"));
        listBooks.add(new Book(3, "978-1491950357", "Designing Data-Intensive Applications", "O'Reilly Media", 2017, "Martin Kleppmann"));
        listBooks.add(new Book(4, "978-0132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));
    }

    //method that returns all books
    public List<Book> getBooks(){
        return listBooks;
    }

    //search for a book by its id
    public Book getBookForId(int id){

        for(Book book : listBooks){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    //search for a book by its isbn
    public Book getBookForIsbn(String isbn){

        for(Book book : listBooks){
            if(book.getIsbn() == isbn){
                return book;
            }
        }
        return null;
    }

    //search for a book by its author
    public Book getBookForAuthor(String author){

        for(Book book : listBooks){
            if(book.getAutor() == author){
                return book;
            }
        }
        return null;
        
    }

    //method to save book
    public Book saveBook(Book book){

        listBooks.add(book);
        return book;
    }

    //method to edited a book
    public Book updateBook(Book book){

        int id = 0;
        int idPosition = 0;

        for(int i = 0;i < listBooks.size();i++){
            if(listBooks.get(i).getId() == book.getId()){
                id = book.getId();
                idPosition = i;
            }
        }

        Book book1 = new Book(); 
        book1.setId(id);
        book1.setIsbn(book.getIsbn());
        book1.setTitulo(book.getTitulo());
        book1.setEditorial(book.getEditorial());
        book1.setFechaPublicacion(book.getFechaPublicacion());
        book1.setAutor(book.getAutor());

        listBooks.set(idPosition,book1);

        return book1;

    }
}
