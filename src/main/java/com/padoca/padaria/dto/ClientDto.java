package com.padoca.padaria.dto;

import com.padoca.padaria.entities.Client;

import java.time.LocalDate;

public class ClientDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthdate;
    private String password;

    public ClientDto(Long id, String name, String email, String phone, LocalDate birthdate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
        this.password = password;
    }

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.phone = client.getPhone();
        this.birthdate = client.getBirthdate();
        this.password = client.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getPassword() {
        return password;
    }
}
