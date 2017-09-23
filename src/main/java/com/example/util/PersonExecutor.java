package com.example.util;
/**
 * Class PersonExecutor, responsável pela intermediação entre a view e a camada de serviço
 *
 * @author Eli Gomes
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Class PersonExecutor, responsável pela criação de pools de threads assincrono de forma que, caso
 * a aplicação tenha alguma indisponibilidade da base de dados, a mesma poderá continuar efetuando cadastros
 * normalmente e quando voltar ao normal os dados serão cadastrados na base dados.
 *
 * @author Eli Gomes
 */

@Configuration
public class PersonExecutor {

    private static final Logger logger = LoggerFactory.getLogger(PersonExecutor.class);

    @Value("${person.thread.core-pool}")
    private int corePoolSize;

    @Value("${person.thread.max-pool}")
    private int maxPoolSize;

    @Value("${person.queue.capacity}")
    private int queueCapacity;

    @Bean
    @Qualifier("personExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        logger.info("ThreadPoolTaskExecutor set");

        return threadPoolTaskExecutor;
    }
}
