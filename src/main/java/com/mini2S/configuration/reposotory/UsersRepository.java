package com.mini2S.configuration.reposotory;

import com.mini2S.biz.user.model.entity.Users;
import com.mini2S.biz.user.model.vo.UsersVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserEmailOrderByUserSeq(String userEmail);

    Optional<Users> findByUserEmail(String email);

    @Query(value = " SELECT a.coordx, a.coordy " +
                    " FROM Users a " +
                    " WHERE a.user_email = :userEmail "
                    , nativeQuery = true)
    UsersVO findUserCoordinateByUserEmail(@Param("userEmail") String userEmail);
}
