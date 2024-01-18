package com.springboot.practo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.practo.Entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
	@Query("SELECT u FROM User u WHERE u.email_id = :email_id")
	Optional<User> findByEmail_id(String email_id);
}
