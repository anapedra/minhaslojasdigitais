package com.amaressantana.minhaslojasdigitais.repositorys;

import com.amaressantana.minhaslojasdigitais.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
