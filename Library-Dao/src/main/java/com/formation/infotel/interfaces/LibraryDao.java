package com.formation.infotel.interfaces;

import java.util.List;

import com.formation.infotel.entity.Library;



public interface LibraryDao {

    void insertLibrary(Library library);

    Library  getLibraryById(int libraryId);

    Library  getLibrary(String libraryname);

    List<Library> getLibrary();
	
}
