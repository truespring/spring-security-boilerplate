package com.mini2S.reposotory;

import com.mini2S.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@EnableJpaRepositories
public interface RolesRepository extends JpaRepository<Roles, Long> {
    public Roles findByRoleName(String roleName);

    public Roles findByRoleSeq(Long roleSeq);

    @Transactional
    @Modifying
    @Query(value = " INSERT INTO user_role " +
                            " ( " +
                            "   user_seq, " +
                            "   role_seq) " +
                            " VALUES " +
                            " (" +
                            "   :UserSeq, " +
                            "   :RoleSeq" +
                            " ) "
                            , nativeQuery = true)
    void insertUserRole(
                        @Param("UserSeq") Long UserSeq,
                        @Param("RoleSeq") Long RoleSeq
    );

}
