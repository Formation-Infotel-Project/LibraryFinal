package com.formation.infotel.interfaces;

import java.util.List;

import com.formation.infotel.entity.Catalog;

public interface CatalogDao {

    void insertAuthor(Catalog catalog);

    Catalog getAuthorById(int catalogId);

    Catalog getAuthor(String catalogName);

    List<Catalog> getCatalog();
	
}
