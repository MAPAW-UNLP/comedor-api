package unlp.info.mapaw.comedor.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import unlp.info.mapaw.comedor.dto.UserDTO;
import unlp.info.mapaw.comedor.security.SecuredUser;

public class TokenProvider {

	private TokenProvider() {
	}

	public static String generateToken(Authentication authentication) {
		SecuredUser securedUser = (SecuredUser) authentication.getPrincipal();
		return Jwts.builder().claim("id", securedUser.getUser().getId()).claim("fullName", securedUser.getUser().getFullname())
				.claim("dni", securedUser.getUser().getDni()).claim("role", "ROLE_" + securedUser.getUser().getRole().name())
				.signWith(SignatureAlgorithm.HS256, Constants.SIGNING_KEY).compact();
	}

	public static UsernamePasswordAuthenticationToken getAuthentication(final String token, final SecuredUser userDetails) {
		final JwtParser jwtParser = Jwts.parser().setSigningKey(Constants.SIGNING_KEY);
		final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
		final Claims claims = claimsJws.getBody();

		final Collection<SimpleGrantedAuthority> authorities = Arrays.stream(claims.get("role").toString().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
	}

	public static long getId(final String token) {
		final JwtParser jwtParser = Jwts.parser().setSigningKey(Constants.SIGNING_KEY);
		final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
		return Long.valueOf((Integer) claimsJws.getBody().get("id"));
	}

}
