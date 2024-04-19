package com.demo.asyndemo.service;

import java.util.Arrays;
import java.util.List;

import com.demo.asyndemo.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    public List<AppUser> getUser1() throws InterruptedException {
        Thread.sleep(1000);
        log.info("proceso 1 finalizado");
        return Arrays.asList(new AppUser(1, "User 1"),
                             new AppUser(2, "User 2"),
                             new AppUser(3, "User 3"));
    }

    public List<AppUser> getUser2() throws InterruptedException {
        Thread.sleep(3000);
        log.info("proceso 2 finalizado");
        return Arrays.asList(new AppUser(6, "User 6"),
                new AppUser(4, "User 4"),
                new AppUser(5, "User 5"));
    }

    public List<AppUser> getUser3() throws InterruptedException {
        Thread.sleep(2000);
        log.info("proceso 3 finalizado");
        return Arrays.asList(new AppUser(7, "User 7"),
                new AppUser(8, "User 8"),
                new AppUser(9, "User 9"));
    }
}
