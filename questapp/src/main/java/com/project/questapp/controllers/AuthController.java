package com.project.questapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.WorkPlace;
import com.project.questapp.requests.WorkPlaceRequest;
import com.project.questapp.security.JwtTokenProvider;
import com.project.questapp.services.WorkPlaceService;

@RestController
@RequestMapping
public class AuthController {
	
	private AuthenticationManager authenticationManager;
	
	private JwtTokenProvider jwtTokenProvider;
	
	private WorkPlaceService workPlaceService;
	

	
	@PostMapping("/login")
	public String login(@RequestBody WorkPlaceRequest workPlaceRequest) {
		UsernamePasswordAuthenticationToken authToekn = new UsernamePasswordAuthenticationToken(workPlaceRequest.getIsletmeAdi(), workPlaceRequest.getYetkili());
		Authentication auth = authenticationManager.authenticate(authToekn);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		return "Bearer " + jwtToken;
	}
	
	@PostMapping("register")
	public ResponseEntity<String> register(@RequestBody WorkPlaceRequest registerRequest){
		if(workPlaceService.getOneWorkPlace(registerRequest.getIsletmeAdi()) != null) {
			return new ResponseEntity<>("WorkPlace işletme adı.", HttpStatus.BAD_REQUEST);
		}
		WorkPlace workPlace = new WorkPlace();
		workPlace.setIsletmeAdi(registerRequest.getIsletmeAdi());
		workPlace.setYetkili(registerRequest.getYetkili());
		workPlaceService.saveOneworkPlace(workPlace);
		return new ResponseEntity<>("WorkPlace successfully registere", HttpStatus.CREATED);
	}
}
