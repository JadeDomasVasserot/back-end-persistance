package com.persistance.facturation.services;

import com.persistance.facturation.data.models.User;
import com.persistance.facturation.data.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
