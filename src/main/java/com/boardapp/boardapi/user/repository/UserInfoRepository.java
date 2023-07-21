package com.boardapp.boardapi.user.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.user.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{
    
}
