package com.demo.asyndemo.service;

import com.demo.asyndemo.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UserServiceAsync {

    //cada servicio trabajara de forma syncrona y tomara hilos de la configuracion en ExecutorConfig

    @Async("getExecutor")
    public CompletableFuture<List<AppUser>> getUser1() throws InterruptedException {
        Thread.sleep(1000);

        List<AppUser> list = Arrays.asList(new AppUser(1, "User 1"),
                new AppUser(2, "User 2"),
                new AppUser(3, "User 3"));
        log.info("proceso 1 finalizado");
        return CompletableFuture.completedFuture(list);
    }

    @Async("getExecutor")
    public CompletableFuture<List<AppUser>> getUser2() throws InterruptedException {
        Thread.sleep(3000);

        List<AppUser> list = Arrays.asList(new AppUser(4, "User 4"),
                new AppUser(5, "User 5"),
                new AppUser(6, "User 6"));
        log.info("proceso 2 finalizado");
        return CompletableFuture.completedFuture(list);
    }

    @Async("getExecutor")
    public CompletableFuture<List<AppUser>> getUser3() throws InterruptedException {
        Thread.sleep(2000);

        List<AppUser> list = Arrays.asList(new AppUser(7, "User 7"),
                new AppUser(8, "User 8"),
                new AppUser(9, "User 9"));
        log.info("proceso 3 finalizado");
        return CompletableFuture.completedFuture(list);
    }

    @Async("getExecutor")
    public CompletableFuture<List<AppUser>> getUser4() throws InterruptedException {
        Thread.sleep(1500);

        List<AppUser> list = Arrays.asList(new AppUser(10, "User 10"),
                new AppUser(11, "User 11"),
                new AppUser(12, "User 12"));
        log.info("proceso 4 finalizado");
        return CompletableFuture.completedFuture(list);
    }
}
