package com.boardapp.boardapi.user.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.user.model.User;

public interface UserRepository extends CrudRepository<User, String>{
    
}
