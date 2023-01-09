package com.project.questapp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.questapp.entities.WorkPlace;
import com.project.questapp.repos.WorkPlaceRepository;
import com.project.questapp.security.JwtWorkPlaceUserDetails;

@Service
public class JwtWorkPlaceUserDetailsServiceImpll implements UserDetailsService {

	private WorkPlaceRepository workPlaceRepository;
	
	public JwtWorkPlaceUserDetailsServiceImpll (WorkPlaceRepository workPlaceRepository) {
		this.workPlaceRepository = workPlaceRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String workPlaceName) throws UsernameNotFoundException {
		WorkPlace workPlace = workPlaceRepository.findByWorkPlacename(workPlaceName);
		return JwtWorkPlaceUserDetails.create(workPlace);
	}
	
	public UserDetails loadUserById(Long id) {
		WorkPlace workPlace = workPlaceRepository.findById(id).get();
		return JwtWorkPlaceUserDetails.create(workPlace);
	}

}
