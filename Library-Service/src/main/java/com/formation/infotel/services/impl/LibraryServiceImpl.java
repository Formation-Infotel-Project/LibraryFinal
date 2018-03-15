package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Library;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private Dao dao;

    @Override
    public void insertLibrary(Library library) {
        dao.save(library);
    }

    @Override
    public void deleteLibrary(Library library) {
        dao.delete(library);
    }

    @Override
    public void updateLibrary(Library library) {
        dao.saveOrUpdate(library);
    }

    @Override
    public Library getLibrary(int libraryId) {
        return dao.get(Library.class, libraryId);
    }

    @Override
    public List<Library> getAllLibraries() {
        return dao.getAll(Library.class);
    }
}
