package com.security.ldap.repository;

import com.security.ldap.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail,String> {

    Optional<UserDetail> findByEmail(@Param("email") String email);
}
