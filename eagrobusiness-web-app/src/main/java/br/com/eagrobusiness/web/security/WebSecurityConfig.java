package br.com.eagrobusiness.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.eagrobusiness.web.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UsuarioService usuarioService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                    .antMatchers("/webjars/**","/static/**").permitAll()
                    .antMatchers("/dados-acesso").hasAuthority("ADMIN")
                    .antMatchers("/lista-usuarios").hasAuthority("ADMIN")
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .rememberMe();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
       
    	builder.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());

    	
    	/*builder
                .inMemoryAuthentication()
                .withUser("eduardo").password("$2a$10$RkTVD0vVnTO9PcU2VbSOButxB3bavOmic/.cuhp4.0a9uml5Vg.bm").roles("EDITOR", "ADMIN")
                .and()
                .withUser("fernanda").password("$2a$10$RkTVD0vVnTO9PcU2VbSOButxB3bavOmic/.cuhp4.0a9uml5Vg.bm").roles("EDITOR");
  */
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}