package com.example.service;

/**
 * Class PersonService, responsável pelas regras de negócios
 *
 * @author Eli Gomes
 */

import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {


    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Autowired
    PersonRepository repository;

    /**
     * Método createPerson, responsável pela cadastro de uma nova pessoa.
     *
     * @param person
     */
    public Person createPerson(Person person) {
        return repository.save(person);
    }

    /**
     * Método listPerson, responsável por retorna a lista de pessoas cadastradas
     */
    public List<Person> listPerson() {
        return repository.findAll();
    }

    /**
     * Método deletePerson, responsável pela exclusão de uma pessoa por ID.
     *
     * @param id
     */
    public void deletePerson(Long id) {
        repository.delete(id);
    }

    /**
     * Método findPersonCpf, rresponsável pela pesquisa de uma pessoa por CPF.
     *
     * @param cpf
     */
    public Person findPersonCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    /**
     * Método updatePerson, responsável pela edição de uma pessoa.
     *
     * @param person
     */
    public Person updatePerson(Person person) {
        return repository.saveAndFlush(person);
    }

    /**
     * Método findOnePerson, responsável pela pesquisa de uma pessoa por id.
     *
     * @param id
     */
    public Person findOnePerson(Long id) {
        return repository.findOne(id);
    }
}
