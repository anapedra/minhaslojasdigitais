package com.amaressantana.minhaslojasdigitais.controller.usercontroller;

import com.amaressantana.minhaslojasdigitais.DTOS.UserDTO;
import com.amaressantana.minhaslojasdigitais.model.User;
import com.amaressantana.minhaslojasdigitais.services.userservice.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServices userServices;
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO userDTO){
        var user= new User();
        BeanUtils.copyProperties(userDTO,user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.saveUser(user));
    }
    @GetMapping
    public ResponseEntity<Page<User>> findAll(Pageable pageable){
        Page<User> users=userServices.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userServices.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> AtualizarUsuario(@PathVariable Long id,@RequestBody @Valid UserDTO userDTO){
        var user=new User();
        BeanUtils.copyProperties(userDTO, user);
        userServices.atualizarUser(id,user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.saveUser(user));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daleteUser(@PathVariable Long id){
        userServices.deletarUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("USUARIO APAGADO COM SUCESSO!");
    }

}
