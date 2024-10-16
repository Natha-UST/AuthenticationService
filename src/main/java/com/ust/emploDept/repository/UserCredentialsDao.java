package com.ust.emploDept.repository;



import com.ust.emploDept.entity.UserCridentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsDao extends JpaRepository<UserCridentialsEntity, Long> {
    public Optional<UserCridentialsEntity> findByName(String username);
}

