package com.example.demo.Services;

import com.example.demo.Entity.Login;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Random;

@Repository
public class LoginDAOImpl implements  LoginDAO{
    private EntityManager manager;
    private Session sesh;
    private Random rand;

    @Autowired
    public LoginDAOImpl(EntityManager manager){this.manager=manager;}

    @Override
    @Transactional
    public Login saveAdmin(Login admin) {
        sesh = manager.unwrap(Session.class);
        sesh.saveOrUpdate(admin);
        return admin;
    }

    public List<Login> listInventory() {
        Session session = manager.unwrap(Session.class);
        List info= session.createQuery("from Login").list();
        session.close();
        return  info;
    }

    @Override
    @Transactional
    public Login getAdmin(int id) {
        sesh= manager.unwrap(Session.class);
        Login user= sesh.get(Login.class,id);
        return user;
    }

    @Override
    @Transactional
    public boolean checkAdmin(Login Admin) {
    List<Login> list = listInventory();
    for(Login a :list)
    {
        if(a.getUsername().equals(Admin.getUsername())){
            if (a.getPassword().equals(Admin.getPassword()))
            {
                return true;
            }
        }

    }
        return false;
    }

}
