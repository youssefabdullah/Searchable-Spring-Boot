package com.example.SearchableSpringboot.dto;

import app.tozzi.annotations.Searchable;
import com.example.SearchableSpringboot.entity.CompanyEntity;
import lombok.Data;

import java.util.Date;

@Data
public class Person {

    @Searchable
    private String firstName;

    @Searchable
    private String lastName;

    @Searchable(entityFieldKey = "dateOfBirth")
    private Date birthDate;

    @Searchable
    private String country;

    private Company company;

    @Data
    public static class Company {

        @Searchable
        private String name;

        @Searchable
        private int employees;
    }
}