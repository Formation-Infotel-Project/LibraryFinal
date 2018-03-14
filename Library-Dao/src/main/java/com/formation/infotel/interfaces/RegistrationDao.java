package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Registration;

import java.util.List;



public interface RegistrationDao {
	
    void insertRegistration(Registration registration);

    void updateRegistration(Registration registration);

    Registration getRegistrationById(int registrationId);

    Registration getRegistration(String registrationName);

    List<Registration> getRegistrations();
	
}
