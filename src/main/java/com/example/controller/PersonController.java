package com.example.controller;
/**
 * Class PersonController, responsável pela intermediação entre a view e a camada de serviço
 *
 * @author Eli Gomes
 */

import java.util.List;

import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "person", description = "Controller para Cadastro de Pessoas")
@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PersonController {

    @Autowired
    private PersonService service;

    @ApiOperation(value = "Lista de Pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Você não tem autorização para listar pessoas!"),
            @ApiResponse(code = 403, message = "Permissão de acesso negada!"),
            @ApiResponse(code = 404, message = "Página não encontrada!") })
    @GetMapping
    public List<Person> listPerson() {

        return service.listPerson();
    }

    @ApiOperation(value = "Cadastro de Pessoas de forma assíncrona",response = Person.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Pessoa cadastrada com sucesso!"),
            @ApiResponse(code = 401, message = "Você não tem autorização para criar uma pessoa!"),
            @ApiResponse(code = 403, message = "Permissão de acesso negada!"),
            @ApiResponse(code = 404, message = "Página não encontrada!") })
    @Async("personExecutor")
    @PostMapping("/add")
    public Person create(@RequestBody Person person) throws InterruptedException {
        /**
         * efetua o cadastro de usuarios em lote no banco de dados a cada 20 segundos,
         * caso necessite efetuar o cadastro sem time comente a linha abaixo.
         * */
        Thread.sleep(20000);
        return service.createPerson(person);
    }

    @ApiOperation(value = "Edição de Pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Pessoa atualizada com sucesso!"),
            @ApiResponse(code = 401, message = "Você não tem autorização para editar pessoa!"),
            @ApiResponse(code = 403, message = "Permissão de acesso negada!"),
            @ApiResponse(code = 404, message = "Página não encontrada!") })
    @PutMapping("/edit/{id}")
    public Person update(@RequestBody Person person, @PathVariable Long id) {
        person.setId(id);
        return service.updatePerson(person);
    }

    @ApiOperation(value = "Exclusão de Pessoa")
    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa deletada com sucesso!"),
            @ApiResponse(code = 401, message = "Você não tem autorização para deletar pessoa!"),
            @ApiResponse(code = 403, message = "Permissão de acesso negada!"),
            @ApiResponse(code = 404, message = "Página não encontrada!") })
    public void delete(@PathVariable Long id) {

        service.deletePerson(id);
    }

    @ApiOperation(value = "Pesquisa Pessoa por cpf")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Você não tem autorização para pesquisar pessoas!"),
            @ApiResponse(code = 403, message = "Permissão de acesso negada!"),
            @ApiResponse(code = 404, message = "Página não encontrada!") })
    @GetMapping("/search/{cpf}")
    public Person findPersonCpf(@PathVariable String cpf) {

        return service.findPersonCpf(cpf);
    }
}
