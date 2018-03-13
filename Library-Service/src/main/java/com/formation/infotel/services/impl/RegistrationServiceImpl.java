package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Registration;
import com.formation.infotel.interfaces.RegistrationDao;
import com.formation.infotel.services.interfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationDao registrationDao;

    @Override
    public void insertRegistration(Registration registration) {
        registrationDao.insertRegistration(registration);
    }
}
