package com.formation.infotel.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Library {

	@Id
	@GeneratedValue
	private int libraryCode;
	private String libraryName;
	private String libraryAddress;

	@OneToOne(mappedBy = "library")
	private Registration registration;

    @ManyToMany(mappedBy = "libraries")
    private List<Catalog> catalogs = new ArrayList<>();

	public Library(String libraryName, String libraryAddress, Registration registration, List<Catalog> catalogs) {
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
		this.registration = registration;
		this.catalogs = catalogs;
	}

	public Library(String libraryName, String libraryAddress,List<Catalog> catalogs) {

		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
		this.catalogs = catalogs;
	}

	public Library(String libraryName, String libraryAddress, Registration registration) {
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
		this.registration = registration;
	}

	public Library(String libraryName, String libraryAddress) {
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
	}

	public Library() {

	}

	public int getLibraryCode() {
		return libraryCode;
	}

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

	public void setLibraryCode(int libraryCode) {
		this.libraryCode = libraryCode;
	}
	
	public List<Catalog> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}
}
