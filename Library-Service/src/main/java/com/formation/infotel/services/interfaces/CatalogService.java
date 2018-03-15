package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Catalog;

import java.util.List;

public interface CatalogService {

    void insertCatalog(Catalog catalog);

    void deleteCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);

    Catalog getCatalog(int catalogId);

    List<Catalog> getAllCatalogs();

    Catalog getCatalogByName(String name);
}
