package com.formation.infotel.controller.dto;

import java.util.ArrayList;
import java.util.List;



import com.formation.infotel.entity.Registration;

public class LibraryDto {

	
	private int libraryCode;
	private String libraryName;
	private String libraryAddress;


	private List<Integer> registrationsId;


    private List<Integer> catalogsId;


	public String getLibraryName() {
		return libraryName;
	}


	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}


	public String getLibraryAddress() {
		return libraryAddress;
	}


	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}


	public int getLibraryCode() {
		return libraryCode;
	}


	public List<Integer> getRegistrationsId() {
		return registrationsId;
	}


	public List<Integer> getCatalogsId() {
		return catalogsId;
	}


	public LibraryDto(int libraryCode, String libraryName, String libraryAddress, List<Integer> registrationsId,
			List<Integer> catalogsId) {
		this.libraryCode = libraryCode;
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
		this.registrationsId = registrationsId;
		this.catalogsId = catalogsId;
	}
    
    
    
}
