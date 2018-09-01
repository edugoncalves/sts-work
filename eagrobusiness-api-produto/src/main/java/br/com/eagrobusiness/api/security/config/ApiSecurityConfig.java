package br.com.eagrobusiness.api.security.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.eagrobusiness.api.security.jwt.JWTUtil;
import br.com.eagrobusiness.api.security.jwt.filter.JWTAuthenticationFilter;
import br.com.eagrobusiness.api.security.jwt.filter.JWTAuthorizationFilter;
import br.com.eagrobusiness.api.service.UsuarioService;






@Configuration
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] API_PUBLIC_REQUEST = { "/produtos/**" };
	
	private static final String[] API_AUTHORIZED_REQUEST= { "/produto/**" };
	
	private static final String PERFIL_ADMIN_KEY="ADMIN";
	
	private static final String PERFIL_CLIENTE_ESPECIAL_KEY="CLIENTE_ESPECIAL";



	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	JWTUtil jwtUtil;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, API_PUBLIC_REQUEST).permitAll()
            .antMatchers(HttpMethod.GET,API_AUTHORIZED_REQUEST)
            		.hasAnyAuthority(PERFIL_ADMIN_KEY,PERFIL_CLIENTE_ESPECIAL_KEY)
            .antMatchers(HttpMethod.POST,API_AUTHORIZED_REQUEST)
            		.hasAnyAuthority(PERFIL_ADMIN_KEY)
            .antMatchers(HttpMethod.PUT,API_AUTHORIZED_REQUEST)
            		.hasAnyAuthority(PERFIL_ADMIN_KEY)
            .antMatchers(HttpMethod.DELETE,API_AUTHORIZED_REQUEST)
            		.hasAnyAuthority(PERFIL_ADMIN_KEY)
			.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, usuarioService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
}
	

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {

		builder.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());

	}
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
