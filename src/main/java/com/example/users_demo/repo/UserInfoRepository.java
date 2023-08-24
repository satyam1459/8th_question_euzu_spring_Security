package com.example.users_demo.repo;

import com.example.users_demo.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    Optional<UserInfo> findByEmail(String username);

    public UserInfo findByEmailAndMobileNumber(String email,String mobileNumber);
}
