package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Library;
import com.formation.infotel.interfaces.LibraryDao;
import com.formation.infotel.services.interfaces.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDao libraryDao;

    @Override
    public void insertLibrary(Library library) {

    }

    @Override
    public void updateLibrary(Library library, int libraryId) {

    }

    @Override
    public void deleteLibrary(Library library) {

    }

    @Override
    public Library getLibraryById(int libraryId) {
        return libraryDao.getLibraryById(libraryId);
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryDao.getLibraries();
    }
}
