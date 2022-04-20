package com.codingdojo.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.authentication.models.LoginUser;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
//	public UserService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	//CREATE USER
	public User createUser(User user) {
		return userRepository.save(user);
	}
	// TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional<User> maybeUser = userRepository.findByEmail(newUser.getEmail());

    	if(maybeUser.isPresent() == true) {
    		result.rejectValue("email", "unique", "Email already exist");
    	}
    	System.out.println(newUser.getPassword() + "--"+ newUser.getConfirm());
    	
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		 result.rejectValue("password", "matches", "The confirm password does not match the Password");		 
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
        return userRepository.save(newUser);
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional<User> maybeUser = userRepository.findByEmail(newLoginObject.getEmail());
    	if(!maybeUser.isPresent()) {
    		result.rejectValue("email", "unique", "Unknown email");
    		return null;
    		
    	}
    	User user = maybeUser.get();
    	System.out.println(user.getPassword());
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())){
    		result.rejectValue("password", "matches", "Incorrect password");
    		return null;
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
        return user;
    }
}
