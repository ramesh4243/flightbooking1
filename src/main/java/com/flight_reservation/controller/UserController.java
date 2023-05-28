package com.flight_reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation.entities.User;
import com.flight_reservation.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistration() {
		return"login/showRegistration";
	}
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}
	@RequestMapping("/saveReg")
	public String saveRegistration(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "login/login";
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model map) {
		User user = userRepository.findByEmail(email);
		if(user!=null) {                                                            //Null pointer exception handling !!
		if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
		return "login/findFlight";
	}else {
		map.addAttribute("error", "Invalid Email/Password");
		return "login/login";
	}
		}else {
			map.addAttribute("error", "Invalid Email/Password");
			return "login/login";
		}

	}
}
