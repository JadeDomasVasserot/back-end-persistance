package com.persistance.facturation.controllers;

import com.persistance.facturation.models.User;
import com.persistance.facturation.repositories.UserRepository;
import com.persistance.facturation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://127.0.0.1:3000"})
@RequestMapping("/user")
@RestController
//@Tag(name = "Personne ")
public class UserController {

    private UserService userService;

    @GetMapping("/all")
    //@Operation(summary = "récupère tous les utilisateurs")
    public ResponseEntity<List<User>> getAllUser() {
        try {
            List<User> users = userService.findAll();
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/id/{idUsere}")
    //@Operation(summary = "récupère un utilisateur")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("idUser") int idUser) {
        try {
            Optional<User> user = userService.findById(idUser);
            if (user.isPresent()) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    //@Operation(summary = "ajoute un utilisateur")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    //@Operation(summary = "modifie un utilisateur")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (user != null) {
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    //@Operation(summary = "supprime un utilisateur")
    public ResponseEntity<HttpStatus> deletePersonne(@PathVariable("id") int id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/all")
    //@Operation(summary = "supprimer tous les utilisateurs")
    public ResponseEntity<HttpStatus> deleteAllPersonnes() {
        try {
            userService.deleteAllUser();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}