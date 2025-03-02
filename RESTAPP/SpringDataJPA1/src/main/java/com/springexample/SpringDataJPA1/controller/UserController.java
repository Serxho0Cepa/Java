package com.springexample.SpringDataJPA1.controller;

import com.springexample.SpringDataJPA1.model.dto.UserDTO;
import com.springexample.SpringDataJPA1.model.dto.UserRequestDTO;
import com.springexample.SpringDataJPA1.model.entity.User;
import com.springexample.SpringDataJPA1.repository.UserRepository;
import com.springexample.SpringDataJPA1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/flight/{flightId}", produces = "application/json")
    public ResponseEntity<List<UserDTO>> getUsersByFlight(@PathVariable Long flightId) {
        List<UserDTO> users = userService.getUsersByFlightId(flightId);
        return users.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(users);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDTO> createOrUpdateUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.createOrUpdateUser(userRequestDTO, null));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
