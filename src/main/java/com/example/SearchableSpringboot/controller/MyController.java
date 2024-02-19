package com.example.SearchableSpringboot.controller;


import com.example.SearchableSpringboot.dto.Person;
import com.example.SearchableSpringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @Autowired
    private PersonService personManager;

    @GetMapping(path="/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findPersons(@RequestParam Map<String, String> requestParams) {
        return personManager.find(requestParams);
    }
}