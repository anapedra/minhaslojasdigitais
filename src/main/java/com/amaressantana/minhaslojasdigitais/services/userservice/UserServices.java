package com.amaressantana.minhaslojasdigitais.services.userservice;

import com.amaressantana.minhaslojasdigitais.model.User;
import com.amaressantana.minhaslojasdigitais.repositorys.UserRepository;
import com.amaressantana.minhaslojasdigitais.services.exeptions.EntityNotFoundExcepion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class UserServices {
    private final UserRepository userRepository;
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(User user){
        user.setDataCriacao(Instant.now());
        return userRepository.saveAndFlush(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundExcepion("Id "+id+" not found"));
    }

    public Page<User> findAll(Pageable pageable){
        Page<User>users=userRepository.findAll(pageable);
        return users;
    }
    public User atualizarUser(Long id, User user){
        findById(id);
        user.setId(id);
        user.setDataAtualizacao(Instant.now());
        return userRepository.saveAndFlush(user);

    }
    public void deletarUser(Long id){
        findById(id);
        userRepository.deleteById(id);
    }
}
