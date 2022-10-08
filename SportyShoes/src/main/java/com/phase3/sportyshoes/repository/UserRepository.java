package com.phase3.sportyshoes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.phase3.sportyshoes.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByName(String name);

	Optional<User> findByEmail(String email);

}
