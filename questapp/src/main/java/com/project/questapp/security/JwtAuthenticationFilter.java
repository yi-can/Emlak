package com.project.questapp.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.questapp.services.JwtWorkPlaceUserDetailsServiceImpll;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	JwtWorkPlaceUserDetailsServiceImpll detailsServiceImpll;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwtToekn = extractJwtFromRequest(request);
			if (StringUtils.hasText(jwtToekn) && jwtTokenProvider.validateToken(jwtToekn)) {
				Long id = jwtTokenProvider.getWorkPlaceIdFromJwt(jwtToekn);
				UserDetails user = detailsServiceImpll.loadUserById(id);
				if (user != null) {
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities() );
					auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			}
		} catch (Exception e) {
			return;
		}
		filterChain.doFilter(request, response);
	}

	private String extractJwtFromRequest(HttpServletRequest request) {
		String bearer = request.getHeader("Authorization");
		if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
			return bearer.substring("bearer".length() + 1);
		}
		return null;
	}
	
}
