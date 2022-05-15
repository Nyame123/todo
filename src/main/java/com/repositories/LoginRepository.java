package com.repositories;

import com.bismark.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface LoginRepository extends JpaRepository<User,Long>{
    
    public void saveUserSession(User user);
}
