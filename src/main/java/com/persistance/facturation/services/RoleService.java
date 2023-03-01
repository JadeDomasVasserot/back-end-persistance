package com.persistance.facturation.services;

import com.persistance.facturation.models.Role;
import com.persistance.facturation.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    RoleRepository roleRepository;

    public List<Role> findAll(){
        return this.roleRepository.findAll();
    }

    public Optional<Role> findById(int idRole){
        return this.roleRepository.findById(idRole);
    }

    public Role addRole (Role role){
        return this.roleRepository.save(role);
    }

    public Role updateRole (Role role){
        return this.roleRepository.save(role);
    }

    public void deleteRole (int id){
        this.roleRepository.deleteById(id);
    }

    public void deleteAllRole (){
        this.roleRepository.deleteAll();
    }
}
