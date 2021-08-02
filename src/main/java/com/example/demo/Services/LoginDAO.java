package com.example.demo.Services;

import com.example.demo.Entity.Login;

public interface LoginDAO {

    Login saveAdmin(Login admin);
    Login getAdmin(int id);
   boolean checkAdmin(Login Admin);
}
