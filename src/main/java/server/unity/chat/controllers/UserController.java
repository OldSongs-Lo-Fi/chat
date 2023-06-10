package server.unity.chat.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import server.unity.chat.entitys.User;
import server.unity.chat.facade.UserFacade;
import server.unity.chat.payloads.DeleteMessage;
import server.unity.chat.payloads.UserPayload;
import server.unity.chat.services.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user/")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/{id}")
    public UserFacade getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        return new UserFacade(user.getNickname(), user.getMessages());
    }

    @GetMapping("/nicknames")
    public Set<String> getUsers(){
        return userService.getUsersNicknames();
    }

    @GetMapping("/all")
    public List<UserFacade> users(){
        List<User> users = userService.getUsers();
        List<UserFacade> userFacades = new ArrayList<>();
        for (User user:
             users) {
            userFacades.add(new UserFacade(user.getNickname(), user.getMessages()));
        }
        return userFacades;
    }

    @PostMapping("/registration")
    public UserFacade addUser(@RequestBody UserPayload userPayload){
        User user = new User(userPayload.getNickname(),
                userPayload.getLogin(),
                passwordEncoder.encode(userPayload.getPassword()));
        System.out.println("User adding: " + user.getNickname());
        User created = userService.createUser(user);
        return new UserFacade(created.getNickname(), created.getMessages());
    }

    @PutMapping("/update/{id}")
    public UserFacade updateUser(@RequestBody UserPayload userPayload,
                           @PathVariable("id") Long id){
        User user = userService.getUserById(id);

        user.setLogin(userPayload.getLogin());
        user.setNickname(userPayload.getNickname());
        user.setPassword(passwordEncoder.encode(userPayload.getPassword()));

        User updated = userService.updateUser(user);
        return new UserFacade(updated.getNickname(), updated.getMessages());
    }

    @DeleteMapping("/delete/{id}")
    public DeleteMessage deleteUserById(@PathVariable("id") Long id){
        return new DeleteMessage(userService.deleteUserById(id));
    }


}
