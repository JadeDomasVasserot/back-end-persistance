package com.persistance.facturation.services;

import com.persistance.facturation.data.models.Contient;
import com.persistance.facturation.data.repositories.ContientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContientService {

    private ContientRepository contientRepository;

    public List<Contient> findAll(){
        return this.contientRepository.findAll();
    }

    public Optional<Contient> findById(long id){
        return this.contientRepository.findById(id);
    }

    public Contient addContient (Contient contient){
        return this.contientRepository.save(contient);
    }

    public Contient updateContient (Contient contient){
        return this.contientRepository.save(contient);
    }

    public void deleteContient (long id){
        this.contientRepository.deleteById(id);
    }

    public void deleteAllContient (){
        this.contientRepository.deleteAll();
    }

}
