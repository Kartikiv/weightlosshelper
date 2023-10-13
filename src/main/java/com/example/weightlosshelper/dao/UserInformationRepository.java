package com.example.weightlosshelper.dao;

import com.example.weightlosshelper.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation,Long> {
    Optional<UserInformation> findByUserName(String userName);
}
