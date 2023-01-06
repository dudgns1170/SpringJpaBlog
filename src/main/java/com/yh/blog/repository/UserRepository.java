package com.yh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yh.blog.model.User;

//DAO
//bean자동 등록이 된다.
@Repository

public interface UserRepository extends JpaRepository<User, Integer>{

}
