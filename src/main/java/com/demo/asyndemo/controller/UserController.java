package com.demo.asyndemo.controller;

import com.demo.asyndemo.models.AppUser;
import com.demo.asyndemo.service.UserService;
import com.demo.asyndemo.service.UserServiceAsync;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserServiceAsync userServiceAsync;

    // sincrono
    @GetMapping
    public List<AppUser> getUsers() throws InterruptedException {
        List<AppUser> list1 = userService.getUser1();
        List<AppUser> list2 = userService.getUser2();
        List<AppUser> list3 = userService.getUser3();

        return Stream.of(list1, list2, list3)
                .flatMap(Collection::stream)
                .toList();
    }

    //endpoint asincrono
    @GetMapping("/async")
    public List<AppUser> getUsersAsync() throws InterruptedException, ExecutionException {
        CompletableFuture<List<AppUser>> list1 = userServiceAsync.getUser1();
        CompletableFuture<List<AppUser>> list2 = userServiceAsync.getUser2();
        CompletableFuture<List<AppUser>> list3 = userServiceAsync.getUser3();
        CompletableFuture<List<AppUser>> list4 = userServiceAsync.getUser4();

        CompletableFuture.allOf(list1, list2, list3, list4).join();
        return Stream.of(list1.get(),list2.get(), list3.get(), list4.get())
                .flatMap(Collection::stream)
                .toList();
    }
}
