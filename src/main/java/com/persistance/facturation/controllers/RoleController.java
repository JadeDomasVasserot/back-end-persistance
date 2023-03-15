package com.persistance.facturation.controllers;

import com.persistance.facturation.DATA.models.Role;
import com.persistance.facturation.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class RoleController {
    private RoleService roleService;

    @GetMapping("/all")
    //@Operation(summary = "récupère tous les utilisateurs")
    public ResponseEntity<List<Role>> getAllRole() {
        try {
            List<Role> roles = roleService.findAll();
            if (roles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/id/{idRole}")
    //@Operation(summary = "récupère un utilisateur")
    public ResponseEntity<Optional<Role>> getRoleById(@PathVariable("idRole") int idRole) {
        try {
            Optional<Role> role = roleService.findById(idRole);
            if (role.isPresent()) {
                return new ResponseEntity<>(role, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    //@Operation(summary = "ajoute un utilisateur")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        try {
            return new ResponseEntity<>(roleService.addRole(role), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    //@Operation(summary = "modifie un utilisateur")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        if (role != null) {
            return new ResponseEntity<>(roleService.updateRole(role), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    //@Operation(summary = "supprime un utilisateur")
    public ResponseEntity<HttpStatus> deletePersonne(@PathVariable("id") int id) {
        try {
            roleService.deleteRole(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/all")
    //@Operation(summary = "supprimer tous les utilisateurs")
    public ResponseEntity<HttpStatus> deleteAllPersonnes() {
        try {
            roleService.deleteAllRole();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
