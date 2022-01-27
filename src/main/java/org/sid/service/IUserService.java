
package org.sid.service;

import org.sid.DTO.UserRegistrationDto;
import org.sid.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);

	User getUser(String email);

	List<User> getAllUsers();

	void saveUser(User user);

	void deleteUser(String mail);

	User getUserById(Integer integer);

}
