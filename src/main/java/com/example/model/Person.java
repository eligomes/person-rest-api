package com.example.model;

/**
 * Classe Person, entidade persistivel na base de dados mapeada com JPA.
 * e swagger para documentação dos seus atributos
 *
 * @author Eli Gomes
 */

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID da pessoa gerado pelo banco de dados", required = true)
    private Long id;

    @Column
    @ApiModelProperty(notes = "Nome da pessoa")
    private String nome;

    @Column
    @ApiModelProperty(notes = "Sobrenome da pessoa")
    private String sobrenome;

    @Column
    @ApiModelProperty(notes = "Data de nascimento da pessoa")
    private Date nascimento;

    @Column
    @ApiModelProperty(notes = "Endereço da pessoa")
    private String endereco;

    @Column
    @ApiModelProperty(notes = "Telefones da pessoa")
    private HashMap<String, String> telefones;

    @Column(name = "cpf", unique = true)
    @ApiModelProperty(notes = "CPF da pessoa")
    private String cpf;


    public Person() {

    }

    public Person(String nome, String sobrenome, Date nascimento, String endereco, HashMap<String, String> telefones, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.telefones = telefones;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public HashMap<String, String> getTelefones() {
        return telefones;
    }

    public void setTelefones(HashMap<String, String> telefones) {
        this.telefones = telefones;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (nome != null ? !nome.equals(person.nome) : person.nome != null) return false;
        if (sobrenome != null ? !sobrenome.equals(person.sobrenome) : person.sobrenome != null) return false;
        if (nascimento != null ? !nascimento.equals(person.nascimento) : person.nascimento != null) return false;
        if (endereco != null ? !endereco.equals(person.endereco) : person.endereco != null) return false;
        if (telefones != null ? !telefones.equals(person.telefones) : person.telefones != null) return false;
        return cpf != null ? cpf.equals(person.cpf) : person.cpf == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (nascimento != null ? nascimento.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (telefones != null ? telefones.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        return result;
    }
}
