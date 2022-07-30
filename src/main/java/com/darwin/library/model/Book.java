package com.darwin.library.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    public Integer id;

    @Column(name="name", nullable = false)
    public String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    public String genre;
}