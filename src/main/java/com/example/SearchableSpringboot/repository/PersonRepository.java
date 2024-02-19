package com.example.SearchableSpringboot.repository;

import app.tozzi.repository.JPASearchRepository;
import com.example.SearchableSpringboot.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long>, JPASearchRepository<PersonEntity> {

}
