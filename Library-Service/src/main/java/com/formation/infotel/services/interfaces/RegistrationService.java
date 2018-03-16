package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.MemLibId;
import com.formation.infotel.entity.Registration;

import java.util.List;

public interface RegistrationService {

    void insertRegistration(Registration registration);

    void deleteRegistration(Registration registration);

    void updateRegistration(Registration registration);

    Registration getRegistration(MemLibId registrationId);

    List<Registration> getAllRegistrations();
}
