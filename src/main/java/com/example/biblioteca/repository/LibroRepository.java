package com.example.biblioteca.repository;

import com.example.biblioteca.model.Libro;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //Especialización de la anotación @Component
//Se usa para anotar clases que acceden a la base de datos, encapsulan el
//almacenamiento, recuperación y búsqueda de objetos de dominio.

public class LibroRepository {

    //Array que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

}
