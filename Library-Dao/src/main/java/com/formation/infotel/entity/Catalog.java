package com.formation.infotel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Catalog {

    @Id
    @GeneratedValue
    private int catalogId;
    private String name;

    @OneToMany(mappedBy = "catalog")
    private List<Book> books = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "LIB_CATA",
        joinColumns = @JoinColumn(name = "CATA_ID"),
        inverseJoinColumns = @JoinColumn(name = "LIB_ID"))
	private List<Library> libraries = new ArrayList<>();

    public Catalog(String name, List<Book> books) {
		this.name = name;
		this.books = books;
	}

    public Catalog(String name, List<Book> books, List<Library> libraries) {
        this.name = name;
        this.books = books;
        this.libraries = libraries;
    }

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }
}
