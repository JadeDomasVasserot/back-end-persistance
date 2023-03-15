package com.persistance.facturation.controllers;

import com.persistance.facturation.DATA.models.Contient;
import com.persistance.facturation.services.ContientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://127.0.0.1:3000"})
@RequestMapping("/contient")
@RestController
//@Tag(name = "Contient ")
public class ContientController {

    private final ContientService contientService;

    public ContientController(ContientService contientService) {
        this.contientService = contientService;
    }

    @GetMapping("/all")
    //@Operation(summary = "récupère tous les liaisons")
    public ResponseEntity<List<Contient>> getAllContient() {
        try {
            List<Contient> contients = contientService.findAll();
            if (contients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(contients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/id/{idContient}")
    //@Operation(summary = "récupère une liaison")
    public ResponseEntity<Optional<Contient>> getContientById(@PathVariable("idContient") int idContient) {
        try {
            Optional<Contient> contient = contientService.findById(idContient);
            if (contient.isPresent()) {
                return new ResponseEntity<>(contient, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    //@Operation(summary = "ajoute une liaison ")
    public ResponseEntity<Contient> createContient(@RequestBody Contient contient) {
        try {
            return new ResponseEntity<>(contientService.addContient(contient), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    //@Operation(summary = "modifie une liaison")
    public ResponseEntity<Contient> updateContient(@RequestBody Contient contient) {
        if (contient != null) {
            return new ResponseEntity<>(contientService.updateContient(contient), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    //@Operation(summary = "supprime une liaison")
    public ResponseEntity<HttpStatus> deletePersonne(@PathVariable("id") int id) {
        try {
            contientService.deleteContient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/all")
    //@Operation(summary = "supprimer touts les liaisons")
    public ResponseEntity<HttpStatus> deleteAllPersonnes() {
        try {
            contientService.deleteAllContient();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/allFromFacture/{idFacture}")
    public ResponseEntity<List<Contient>> getAllContientFromFacture(@PathVariable("idFacture") int idFacture) {
        try {
            List<Contient> contients = contientService.findAllByFacture(idFacture);
            if (contients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(contients, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}