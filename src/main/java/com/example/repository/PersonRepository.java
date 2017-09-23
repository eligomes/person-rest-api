package com.example.repository;

/**
 * Interface PersonRepository, responsável pelo acesso aos dados utlizando o
 * JpaRepository do Spring Data.
 *
 * @author Eli Gomes
 */

import com.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long > {

    public Person findByCpf(String cpf);
}
