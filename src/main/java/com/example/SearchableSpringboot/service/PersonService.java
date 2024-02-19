package com.example.SearchableSpringboot.service;

import com.example.SearchableSpringboot.dto.Person;
import com.example.SearchableSpringboot.entity.PersonEntity;
import com.example.SearchableSpringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> find(Map<String, String> filters) {
        filters.put("birthDate_sort", "ASC");
        filters.put("_limit", "10");
        filters.put("_offset", "0");
        return personRepository.findAllWithPaginationAndSorting(filters, Person.class)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private Person toDTO(PersonEntity personEntity) {
        // ...
        Person person = new Person();
        person.setFirstName(personEntity.getFirstName());
        person.setLastName(personEntity.getLastName());
        return person;
    }

    public void test() {
        // ...

        Map<String, String> filters = new HashMap<>();
        filters.put("firstName_eq", "Biagio");
        filters.put("lastName_startsWith", "Toz");
        filters.put("birthDate_gte", "19910101");
        filters.put("country_in", "IT,FR,DE");
        filters.put("company.name_in", "Microsoft,Apple");
        filters.put("company.employees_between", "500,5000");

        // Without pagination
        List<PersonEntity> fullSearch = personRepository.findAll(filters, Person.class);

        filters.put("birthDate_sort", "ASC");
        filters.put("_limit", "10");
        filters.put("_offset", "0");

        // With pagination
        Page<PersonEntity> sortedAndPaginatedSearch = personRepository.findAllWithPaginationAndSorting(filters, Person.class);

        // ...
    }
}
