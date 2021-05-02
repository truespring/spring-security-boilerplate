package com.mini2S.reposotory;

import com.mini2S.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserEmailOrderByUserSeq(String userEmail);

    Optional<Users> findByUserEmail(String email);
}
