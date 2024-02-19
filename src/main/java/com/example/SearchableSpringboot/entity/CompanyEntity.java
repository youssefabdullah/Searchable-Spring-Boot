package com.example.SearchableSpringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class CompanyEntity {

    @Id
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNT")
    private Integer employeesCount;

}