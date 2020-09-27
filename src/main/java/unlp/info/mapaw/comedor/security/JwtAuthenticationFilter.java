package unlp.info.mapaw.comedor.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import unlp.info.mapaw.comedor.utils.Constants;
import unlp.info.mapaw.comedor.utils.TokenProvider;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		super.setAuthenticationFailureHandler(new JwtAuthenticationFailureHandler());
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			AuthorizationRequest userCredentials = new ObjectMapper().readValue(request.getInputStream(), AuthorizationRequest.class);


			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					userCredentials.getUsername(), userCredentials.getPassword()));
		} catch (IOException e) {
			return null;
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String token = TokenProvider.generateToken(authResult);
		response.addHeader(Constants.HEADER_AUTHORIZATION_KEY, Constants.TOKEN_BEARER_PREFIX + " " + token);
	}
}
