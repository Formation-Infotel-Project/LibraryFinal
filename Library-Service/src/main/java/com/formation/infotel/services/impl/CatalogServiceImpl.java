package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Catalog;
import com.formation.infotel.interfaces.CatalogDao;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    CatalogDao catalogDao;
    @Autowired
    private Dao dao;

    @Override
    public void insertCatalog(Catalog catalog) {
        dao.save(catalog);
    }

    @Override
    public void deleteCatalog(Catalog catalog) {
        dao.delete(catalog);
    }

    @Override
    public void updateCatalog(Catalog catalog) {
        dao.saveOrUpdate(catalog);
    }

    @Override
    public Catalog getCatalog(int catalogId) {
        return dao.get(Catalog.class, catalogId);
    }

    @Override
    public List<Catalog> getAllCatalogs() {
        return dao.getAll(Catalog.class);
    }

    @Override
    public Catalog getCatalogByName(String name) {
        return catalogDao.getCatalogByname(name);
    }
}
