package com.example.demo.Controller;

import com.example.demo.Entity.Login;
import com.example.demo.Repositories.LoginRepository;
import com.example.demo.Services.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController

public class LoginController {
    private final LoginDAO loginDAO;

    public LoginRepository loginRepository;
    @Autowired
    public LoginController(LoginDAO loginDAO)
    {
        this.loginDAO = loginDAO;
    }

    @PostMapping("/addAdmin")
    public Login createAdmin(@RequestBody Login admin){

        return loginRepository.save(admin);
    }
    @DeleteMapping
    public void deleteUser(@RequestBody Login admin)
    {
        loginRepository.existsById(1L);
        loginRepository.delete(admin);
    }

    @PostMapping("/checkAdmin")
        public String checker(@RequestBody Login admin)
        {
            if(loginDAO.checkAdmin(admin))
            {
                return "Success";
            }
            else
            {
                return "Failure";
            }


        }

}
