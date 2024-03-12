package com.example.organisationalstructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByEmail(String email);

    List<User> findByNameAndEmail(String name, String email);

}
