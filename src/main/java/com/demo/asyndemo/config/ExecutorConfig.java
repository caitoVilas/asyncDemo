package com.demo.asyndemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ExecutorConfig {
    //esta clase va a configurar un pool de thread con un ejecutor

    @Bean(name = "getExecutor")
    public Executor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        /*executor.setCorePoolSize(6); // cantidad de hilos que se ejecutan de forma simultanea
        executor.setMaxPoolSize(20); //numero de hilos que se crean y estan a la espera de ser atendidos
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("proceso-");
        executor.initialize();*/
        executor.setCorePoolSize(3); // cantidad de hilos que se ejecutan de forma simultanea
        executor.setMaxPoolSize(3); //numero de hilos que se crean y estan a la espera de ser atendidos
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("proceso-");
        executor.initialize();

        return executor;
    }
}
