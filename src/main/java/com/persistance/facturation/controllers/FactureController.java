package com.persistance.facturation.controllers;


import com.persistance.facturation.data.models.Facture;
import com.persistance.facturation.services.FactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://127.0.0.1:3000"})
@RequestMapping("/facture")
@RestController

public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Facture>> getAllFacture()
    {
        try{
            List<Facture> listFacture = factureService.findAllFacture();
            if (listFacture.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listFacture, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getone/{idFacture}")
    public ResponseEntity<Facture> getFactureById(@PathVariable("idFacture") int idFac)
    {
        try{
            Facture facture = factureService.findOneFacture(idFac);
            if (facture != null){
                return new ResponseEntity<>(facture, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Facture> addFacture(@RequestBody Facture facture)
    {
        try{
            return new ResponseEntity<>(factureService.addFacture(facture), HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{idFacture}")
    public ResponseEntity deleteFacture(@PathVariable("idFacture") int idFac)
    {
        try{
            factureService.deleteFacture(idFac);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateFacture(@RequestBody Facture facture)
    {
        try{
            factureService.modifyFacture(facture);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getall/{idUser}")
    public ResponseEntity<List<Facture>> getAllFactureByUser(@PathVariable("iduser") int idUser)
    {
        try{
            var listFac = factureService.findAllFactureByUser(idUser);
            return new ResponseEntity<>(listFac, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllFactureByDate/{date}")
    public ResponseEntity<List<Facture>> getAllFactureByDate(@PathVariable("date") String date){
        try{
            List<Facture> listFac = this.factureService.findAllFactureByDate(date);
            return new ResponseEntity<>(listFac, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
