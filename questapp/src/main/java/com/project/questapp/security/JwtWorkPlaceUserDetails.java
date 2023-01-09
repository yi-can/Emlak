package com.project.questapp.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.questapp.entities.WorkPlace;

import java.util.List;


public class JwtWorkPlaceUserDetails implements UserDetails{
	
	Long id;
	private String IsletmeAdi;
	private String Yetkili;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtWorkPlaceUserDetails(Long id, String Yetkili, String IsletmeAdi,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.Yetkili = Yetkili;
		this.IsletmeAdi = IsletmeAdi;
		this.authorities = authorities;
	}
	
	public static JwtWorkPlaceUserDetails create(WorkPlace workPlace) {
		List<GrantedAuthority> authoritiesList = new ArrayList<>();
		authoritiesList.add(new SimpleGrantedAuthority("workPlace"));
		return new JwtWorkPlaceUserDetails(workPlace.getId(), workPlace.getYetkili(), workPlace.getIsletmeAdi(), authoritiesList);
	}
	
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
