package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Library;

import java.util.List;

public interface LibraryService {

    void insertLibrary(Library library);

    void updateLibrary(Library library, int libraryId);

    void deleteLibrary(Library library);

    Library getLibraryById(int libraryId);

    List<Library> getAllLibraries();
}
