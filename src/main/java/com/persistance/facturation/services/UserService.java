package com.persistance.facturation.services;

import com.persistance.facturation.models.User;
import com.persistance.facturation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public Optional<User> findById(int idUser){
        return this.userRepository.findById(idUser);
    }

    public User addUser (User user){
        return this.userRepository.save(user);
    }

    public User updateUser (User user){
        return this.userRepository.save(user);
    }

    public void deleteUser (int id){
        this.userRepository.deleteById(id);
    }

    public void deleteAllUser (){
        this.userRepository.deleteAll();
    }
}
