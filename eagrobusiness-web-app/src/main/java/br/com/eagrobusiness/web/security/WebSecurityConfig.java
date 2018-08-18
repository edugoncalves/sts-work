package br.com.eagrobusiness.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.eagrobusiness.web.service.UsuarioService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final String[] RESOURCES_PATH= {"/","/img/**","/js/**","/css/**","/fonts/**","/skin/**","/contactform/**",
			"/webjars/**","/resources/**","/static/**","/templates/**","/public"};

	@Autowired
	UsuarioService usuarioService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                	.antMatchers(RESOURCES_PATH).permitAll().anyRequest().permitAll()
                    .antMatchers("/dados-acesso").hasAnyAuthority("ADMIN","CLIENTE_ESPECIAL")
                    .antMatchers("/lista-usuarios").hasAuthority("ADMIN")
                    .antMatchers("/home").hasAnyAuthority("ADMIN","CLIENTE_ESPECIAL","CLIENTE")
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/home")
                    .failureUrl("/login?error=true")
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .rememberMe();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
       
    	builder.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
    	

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(RESOURCES_PATH);
    }

}
