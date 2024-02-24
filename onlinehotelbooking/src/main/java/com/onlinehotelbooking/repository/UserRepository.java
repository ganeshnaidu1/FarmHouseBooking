package com.onlinehotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinehotelbooking.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	@Query("SELECT u FROM User u WHERE u.emailId = :emailId AND u.password = :password")
	 User findByEmailIdAndPassword(@Param("emailId") String emailId, @Param("password") String password);
}

