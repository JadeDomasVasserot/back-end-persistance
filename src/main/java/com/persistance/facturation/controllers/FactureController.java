package com.persistance.facturation.controllers;


import com.persistance.facturation.models.Facture;
import com.persistance.facturation.services.FactureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://127.0.0.1:3000"})
@RequestMapping("/facture")
@RestController

public class FactureController {

    private FactureService factureService;

//    @GetMapping("/all")
//    public ResponseEntity<List<Facture>> getAllFacture()
//    {
//        try{
//            List<Facture> listFacture = factureService.findAll();
//        }
//        catch (Exception ex){
//
//        }
//    }
}
