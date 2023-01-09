package com.project.questapp.security;

import java.security.SignatureException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;




@Component
public class JwtTokenProvider {
	
	@Value("${questapp.app.secret}")
	private String APP_SECRET;
	
	@Value("${questapp.expires.in}")
	private long EXPIRES_IN;
	
	public String generateJwtToken(Authentication auth) {
		JwtWorkPlaceUserDetails jwtWorkPlaceUserDetails = (JwtWorkPlaceUserDetails) auth.getPrincipal();
		//Date expireDate = new Date(new Date().getTime() + EXPIRES_IN);
		/*return Jwts.builder().setSubject((Long.toString(jwtWorkPlaceUserDetails.getId)))
				.setIssuedAt(new Date()).setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, APP_SECRET).compact();*/
		return null;
	}
	
	Long getWorkPlaceIdFromJwt(String token) {
		//Claims claims = JwtSpec.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getbBody();
		//return Long.parseLong(claims.getSunject());
		return null;
	}
	
	boolean validateToken(String token) {
		/*try {
			//Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
			return !isTokenExpired(token);
		} catch (SignatureException e) {
			return false;
		}
		catch (MalformedJwtException e) {
			return false;
		}catch (ExpiredJwtException e) {
			return false;
		}catch (UnsupportedJwtException e) {
			return false;
		}catch (IllegalArgumentException e) {
			return false;
		}*/
		return true;
		
	}

	private boolean isTokenExpired(String token) {
		//Date expiration = JwtSpec.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody.getExpiration();
		//return expiration.before(new Date(EXPIRES_IN));
		return false;
	}
}
