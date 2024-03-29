package com.api.project.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.entity.User;
import com.api.project.repository.UserRepository;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostMapping("login")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		User userDB = userCredentials(username,pwd);
		System.out.println("username: " + username + " - password: " + pwd );
		User user = new User();
		if (userDB != null) {
			String token = getJWTToken(username);
			user.setName(username);
			user.setToken(token);
		}
				
		return user;
		
	}
	
	public User userCredentials (String name, String password) {
		return userRepository.findUser(name, password);
	}
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority>  grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
								.setIssuedAt(new Date(System.currentTimeMillis()))
								.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
	@PostMapping("/user")
	User recordUser(@RequestBody User user) {
		User userRecorded = userRepository.save(user);
		return userRecorded;
	}
	
	@DeleteMapping("/user/{id}")
	void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@PutMapping("/user/{id}")
	void updateUser(@RequestBody User user, @PathVariable int id) {
		User userToUpdate = userRepository.getOne(id);
		userToUpdate.setName(user.getName());
		userToUpdate.setPassword(user.getPassword());
		userRepository.save(userToUpdate);
	}
	
	
	@GetMapping("/principal")
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }
	
	
}
