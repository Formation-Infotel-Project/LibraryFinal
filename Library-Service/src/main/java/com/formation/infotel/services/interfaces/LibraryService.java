package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Library;

import java.util.List;

public interface LibraryService {

    void insertLibrary(Library library);

    void deleteLibrary(Library library);

    void updateLibrary(Library library);

    Library getLibrary(int libraryId);

    List<Library> getAllLibraries();
}
