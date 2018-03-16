package com.formation.infotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.infotel.controller.dto.LibraryDto;
import com.formation.infotel.entity.Library;
import com.formation.infotel.services.interfaces.LibraryService;

public class LibraryController extends HttpServlet{
	
	@Autowired
	LibraryService libraryService;
	
    @PostMapping("/library/add")
    public void LibraryAdd(@RequestBody LibraryDto libraryDto) {
    	Library library = new Library(libraryDto.getLibraryName(), libraryDto.getLibraryAddress(), null);
    	/*jai laissé registration a null*/
    	libraryService.insertLibrary(library);
    }
	
	
    
   /* @RequestMapping("library/get")
    public List<LibraryDto> getLibrary(){
    	
    	List<LibraryDto> viewLibrarys = new ArrayList<>();
    	List<Library> librarys = libraryService.getAllLibraries();
    	List<Integer> registrationsId = new ArrayList<>();
    	
    	librarys.forEach(l -> l.getRegistrations().forEach(b->{ registrations.add(b.)       })	
    			{ viewLibrarys.add(new LibraryDto(l.getLibraryCode(), l.getLibraryName(), l.getLibraryAddress(), l.getRegistrations())});
    	
    		
    	
    	
    	
    	return viewLibrarys;
    }*/

}
