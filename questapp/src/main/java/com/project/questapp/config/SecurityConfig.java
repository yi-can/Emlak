package com.project.questapp.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.project.questapp.security.JwtAuthenticationEntryPoint;
import com.project.questapp.security.JwtAuthenticationFilter;
import com.project.questapp.services.JwtWorkPlaceUserDetailsServiceImpl;

import jakarta.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration{
	
	private static final Class<? extends Filter> UsernamePasswordAuthenticationFilter = null;

	private JwtWorkPlaceUserDetailsServiceImpl userDetailsService;
	
	private JwtAuthenticationEntryPoint handler;

	public SecurityConfig(JwtWorkPlaceUserDetailsServiceImpl userDetailsService, JwtAuthenticationEntryPoint handler) {
		this.userDetailsService = userDetailsService;
		this.handler = handler;
	}
	
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return null;
		//return  super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder();
	}*/
	
	@Bean
	public CorsFilter corsFilter() {
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedOrigin("OPTIONS");
		config.addAllowedOrigin("HEAD");
		config.addAllowedOrigin("GET");
		config.addAllowedOrigin("PUT");
		config.addAllowedOrigin("POST");
		config.addAllowedOrigin("DELETE");
		config.addAllowedOrigin("PATCH");
		source.registerCorsConfiguration("/**", config);
		return null;
		//return new CorsFilter(source);
	}

	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.cors()
			.and()
			.csrf().disable()
			.exceptionHandling().authenticationEntryPoint(handler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//httpSecurity.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter);
	}
}
