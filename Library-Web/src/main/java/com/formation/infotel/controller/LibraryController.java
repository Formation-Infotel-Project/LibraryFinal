package com.formation.infotel.controller;

import java.util.ArrayList;
import java.util.List;

import com.formation.infotel.entity.MemLibId;
import com.formation.infotel.entity.Registration;
import com.formation.infotel.services.interfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.formation.infotel.controller.dto.LibraryDto;
import com.formation.infotel.entity.Library;
import com.formation.infotel.services.interfaces.LibraryService;

@RestController
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	@Autowired
	RegistrationService registrationService;

	@PutMapping(value = "library/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addLibrary(@RequestBody LibraryDto libraryDto) {

		Library library = new Library(libraryDto.getLibraryName(), libraryDto.getLibraryAddress());
		List<Registration> registrations = new ArrayList<>();
		for (int i = 0; i < libraryDto.getRegistrationsId().size(); i++) {
			try {
				registrations.add(registrationService.getRegistration(libraryDto.getRegistrationsId().get(i)));

				library.setRegistrations(registrations);

				libraryService.insertLibrary(library);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@PostMapping(value = "library/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateLibrary(@RequestBody LibraryDto libraryDto, @PathVariable(value = "id") int id) {

		Library library;
		try {
			library = libraryService.getLibrary(id);

			library.setLibraryName(libraryDto.getLibraryName());
			library.setLibraryAddress(libraryDto.getLibraryAddress());
			List<Registration> registrations = new ArrayList<>();
			for (int i = 0; i < libraryDto.getRegistrationsId().size(); i++) {
				registrations.add(registrationService.getRegistration(libraryDto.getRegistrationsId().get(i)));
			}
			library.setRegistrations(registrations);

			libraryService.updateLibrary(library);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DeleteMapping(value = "library/delete/{id}")
	public void deleteLibrary(@PathVariable(value = "id") int id) {

		Library library;
		try {
			library = libraryService.getLibrary(id);
			libraryService.deleteLibrary(library);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("library/get/{id}")
	public LibraryDto getLibrary(@PathVariable(value = "id") int id) {
		Library library;
		LibraryDto viewLibrary = null;
		try {
			library = libraryService.getLibrary(id);

			List<MemLibId> registrationsId = new ArrayList<>();
			library.getRegistrations().forEach(r -> {
				registrationsId.add(r.getId());
			});
			viewLibrary = new LibraryDto(library.getLibraryName(), library.getLibraryAddress(), registrationsId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viewLibrary;
	}

	@RequestMapping("library/get")
	public List<LibraryDto> getLibraries() {
		
		
		List<LibraryDto> viewLibraries = new ArrayList<>();
		
		
		List<Library> libraries;
		try {
			libraries = libraryService.getAllLibraries();
	
		List<MemLibId> registrationsId = new ArrayList<>();
		libraries.forEach(l -> {
			l.getRegistrations().forEach(r -> registrationsId.add(r.getId()));
			viewLibraries.add(new LibraryDto(l.getLibraryName(), l.getLibraryAddress(), registrationsId));
		});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viewLibraries;
	}

}
