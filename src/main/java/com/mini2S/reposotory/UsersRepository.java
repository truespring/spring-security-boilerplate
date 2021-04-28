package com.mini2S.reposotory;

import com.mini2S.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    public Users findByUserEmail(String userEmail);

    Optional<Users> findByEmail(String email);
}
