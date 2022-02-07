package com.RedBusApplication.signup.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser,Long> {


    Optional<AppUser> findByEmail(String email);

    @Modifying
    @Query("update AppUser set is_enabled = true where email =:emailId")
    int enableAppUser(@Param("emailId") String email);
}
