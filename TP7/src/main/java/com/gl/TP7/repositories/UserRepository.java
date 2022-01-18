package com.gl.TP7.repositories;

import com.gl.TP7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(final String name);
}
