package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="admininfo")
public class Login {

    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "ID") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name="Username")
    private String username;

    @Column(name="Password")
    private  String password;






}

