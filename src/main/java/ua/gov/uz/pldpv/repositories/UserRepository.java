package ua.gov.uz.pldpv.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.gov.uz.pldpv.entities.User;

public interface UserRepository extends JpaRepository<User, Serializable> {

	@Query("select u from User u where u.userName=?1 and u.password=?2")
	User login(String userName, String password);
	
	User findByUserNameAndPassword(String userName, String password);

	User findUserByUserName(String userName);
}