package com.mini2S.configuration.reposotory;

import com.mini2S.model.entity.Users;
import com.mini2S.model.vo.UsersVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserEmailOrderByUserSeq(String userEmail);

    Optional<Users> findByUserEmail(String email);

    @Query(value = " SELECT a.coordX, a.coordY " +
                    " FROM Users a " +
                    " WHERE a.userSeq = :userSeq ")
    UsersVO findUserCoordinateByUserSeq(@Param("userSeq") Long userSeq);
}
