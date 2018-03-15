package com.formation.infotel.dto;



public class MemLibld {
	

    private int memberId;


    private int libraryCode;


	public int getMemberId() {
		return memberId;
	}


	public int getLibraryCode() {
		return libraryCode;
	}


	public MemLibld(int memberId, int libraryCode) {
		this.memberId = memberId;
		this.libraryCode = libraryCode;
	}


}
