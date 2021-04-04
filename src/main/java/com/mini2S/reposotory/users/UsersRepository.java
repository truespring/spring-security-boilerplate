package com.mini2S.reposotory.users;

import com.mini2S.entity.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    public Users findByUserId(String userId);
}
