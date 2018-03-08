package com.formation.infotel.dao;

import com.formation.infotel.entity.Registration;
import com.formation.infotel.interfaces.RegistrationDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RegistrationDaoImpl implements RegistrationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertRegistration(Registration registration) {
        sessionFactory.getCurrentSession().save(registration);
    }

    @Override
    public Registration getRegistrationById(int registrationId) {
        return null;
    }

    @Override
    public Registration getRegistration(String registrationName) {
        return null;
    }

    @Override
    public List<Registration> getRegistrations() {
        return null;
    }
}
