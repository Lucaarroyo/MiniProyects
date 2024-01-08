package com.example.bibliotecaaida.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Los arroba son los que nos van a definir que esta clase es una entidad en una BBDD, y
// cada uno de los atributos son las columnas

//Al haber incluido el Lombok no hace falta crear constructores, getter, setter, etc
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;

}
