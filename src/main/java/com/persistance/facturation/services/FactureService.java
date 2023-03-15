package com.persistance.facturation.services;

import com.persistance.facturation.data.models.Facture;
import com.persistance.facturation.data.repositories.FactureRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class FactureService {

    private final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

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

    public Facture addFacture(Facture facture){
        return this.factureRepository.save(facture);
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

    public List<Facture> findAllFactureByUser(int idUser) {
        List<Facture> listFac = null;
        try {
            listFac = this.factureRepository.findFacByUser(idUser);
            if (listFac.isEmpty()) {
                throw new Exception("Impossible de récupérer les factures ou la liste des factures est vide");
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return listFac;
    }

    public List<Facture> findAllFactureByDate(String date) {
        List<Facture> listFac = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date dateFormat = formatter.parse(date);
            listFac = this.factureRepository.findByDateOrderByDateDesc(dateFormat);
            if (listFac.isEmpty()) {
                throw new Exception("Impossible de récupérer les factures ou la liste des factures est vide");
            }
        }
        catch (Exception ex) {
            System.out.print(ex);
        }
        return listFac;
    }
}
