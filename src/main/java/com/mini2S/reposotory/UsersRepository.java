package com.mini2S.reposotory;

import com.mini2S.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Long> {
    public Users findByUserEmail(String userEmail);

}
