package com.mini2S.configuration.reposotory;

import com.mini2S.common.user.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUserEmail(String email);

    /**
     * 사용자 email 로 사용자 조회
     *
     * @param userEmail
     * @return
     */
    Users findByUserEmailOrderByUserSeq(String userEmail);

    /**
     * 사용자 위치 조회
     *
     * @param userEmail
     * @return
     */
    @Query(value = " SELECT a.coordx, a.coordy " +
            " FROM users a " +
            " WHERE a.user_email = :userEmail "
            , nativeQuery = true)
    Map<String, Object> findUserCoordinateByUserEmail(@Param("userEmail") String userEmail);
}
