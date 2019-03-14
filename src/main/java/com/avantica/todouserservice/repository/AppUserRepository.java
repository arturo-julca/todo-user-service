package com.avantica.todouserservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avantica.todouserservice.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{

	@Query("SELECT u FROM AppUser u WHERE u.username = ?1")
	Optional<AppUser> findByUsername(String username);
}
