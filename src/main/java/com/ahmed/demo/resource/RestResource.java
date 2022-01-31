package com.ahmed.demo.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestResource 
{
	@RequestMapping("/pms/userDetails")
	public ResponseEntity<UserProfile> profile() 
	{
		 User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserProfile profile = new UserProfile();
		profile.setName(user.getUsername());
		profile.setEmail("tufailahmedkhan@gmail.com");

		return ResponseEntity.ok(profile);
	}
}
