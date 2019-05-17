package com.esgi.behere.dao;

import com.esgi.behere.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}