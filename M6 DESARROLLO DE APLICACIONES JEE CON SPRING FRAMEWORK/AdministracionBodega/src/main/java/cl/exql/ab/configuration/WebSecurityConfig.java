package cl.exql.ab.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("AdminBodega")
		.password(passwordEncoder().encode("9876")).roles("BODEGA")
		.and()
		.withUser("UserBodega").password(passwordEncoder().encode("5432")).roles("BODEGA");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/materiales/**").hasRole("BODEGA")
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").failureUrl("/login?error=true")
		.usernameParameter("correo").passwordParameter("contrasena")
		.defaultSuccessUrl("/materiales");
	}
	
}
