package com.persistance.facturation.services;

import com.persistance.facturation.models.Facture;
import com.persistance.facturation.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    FactureRepository factureRepository;
    public List<Facture> findAllFacture(){
        var listFac = new ArrayList<Facture>().stream().toList();
        try {
            listFac = this.factureRepository.findAll();
            if (listFac.size() < 1) {
                throw new Exception("Impossible de récupérer les factures ou la liste des factures est vide");
            }
        }
        catch (Exception ex) {
            System.out.print(ex);
        }
        return listFac;
    }

    public Facture findOneFacture(int id){
        var facture = new Facture();
        try {
            var fac = this.factureRepository.findById(id);
            if (fac.isPresent()){
                facture = fac.get();
            }
            else {
                throw new Exception("Impossible de récupérer la facture n° " + id);
            }
        }
        catch (Exception ex) {
            System.out.print(ex);
        }
        return facture;
    }

    public void addFacture(Facture facture){
        try {
            this.factureRepository.save(facture);
        }
        catch (Exception ex) {
            System.out.print(ex);
        }
    }

    public void deleteFacture(int id){
        try {
            var facDel = this.factureRepository.getById(id);
            if (facDel != null) {
                this.factureRepository.delete(facDel);
            }
            else {
                throw new Exception("Impossible de supprimer la facture n° " + id);
            }
            }
        catch (Exception ex) {
            System.out.print(ex);
        }
    }

    public void modifyFacture(Facture facture){
        try{
            Optional<Facture> factureToModif = this.factureRepository.findById(facture.getId());
            if (factureToModif.isPresent())
            {
                Facture facMod = factureToModif.get();
                facMod.setDate(facture.getDate());
                facMod.setContients(facture.getContients());
                facMod.setUser(facture.getUser());
                facMod.setName(facture.getName());
                this.factureRepository.save(facMod);
            }
            else {
                throw new Exception("Impossible de mettre à jour la facture");
            }
        }
        catch (Exception ex) {
            System.out.print(ex);
        }
    }
}
