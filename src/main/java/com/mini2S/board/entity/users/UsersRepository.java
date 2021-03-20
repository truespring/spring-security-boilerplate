package com.mini2S.board.entity.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    public Users findByUserId(String userId);
}
