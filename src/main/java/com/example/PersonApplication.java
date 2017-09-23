package com.example;
/**
 * Class PersonApplication, responsável pela inicialização da aplicação.
 *
 * @author Eli Gomes
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@ComponentScan({"com.example"})
@EnableJpaRepositories
@EnableAsync
public class PersonApplication{

    public static void main(String[] args) throws Exception{
        SpringApplication.run(PersonApplication.class, args);
    }

}
