package com.formation.infotel.services.impl;

import com.formation.infotel.entity.MemLibId;
import com.formation.infotel.entity.Registration;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.interfaces.RegistrationDao;
import com.formation.infotel.services.interfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private Dao dao;
    @Autowired
    private RegistrationDao registrationDao;

    @Override
    public void insertRegistration(Registration registration) {
        dao.save(registration);
    }

    @Override
    public void deleteRegistration(Registration registration) {
        dao.delete(registration);
    }

    @Override
    public void updateRegistration(Registration registration) {
        dao.saveOrUpdate(registration);
    }

    @Override
    public Registration getRegistration(MemLibId registrationId) {
        return registrationDao.getById(registrationId);
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return dao.getAll(Registration.class);
    }
}
