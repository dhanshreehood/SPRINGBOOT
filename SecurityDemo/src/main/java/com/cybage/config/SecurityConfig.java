package com.cybage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
public void configure(AuthenticationManagerBuilder auth) throws Exception
{
		/*auth.inMemoryAuthentication().withUser("Jhon").password("1234").roles("USER")
		.and().withUser("Vijayalaxmi").password("v1234").roles("USER");
	*/
	
	 auth.inMemoryAuthentication()
     .passwordEncoder(passwordEncoder())
     .withUser("Jhon")
     .password(passwordEncoder().encode("1234"))
     .roles("ADMIN")
     .and()
     .passwordEncoder(passwordEncoder())
     .withUser("Roma")
     .password(passwordEncoder().encode("123456"))
     .roles("USER");
}


@Bean
// Method
public PasswordEncoder passwordEncoder()
{
    return new BCryptPasswordEncoder();
}

/*
@Bean 
//Method
public PasswordEncoder getPasswordEncoder()
{
	return NoOpPasswordEncoder.getInstance();
}
*/
@Override
// Method
protected void configure(HttpSecurity http)
    throws Exception
{
    http.httpBasic()
    .and()
    .authorizeRequests()
        .antMatchers("/hello").permitAll()    //hasAnyRole("USER", "ADMIN")
        .antMatchers("/admin").hasRole("ADMIN");
    
   // .antMatchers(HttpMethod.PUT, "/product/**").hasRole("Admin")
    //.antMatchers(HttpMethod.PATCH, "/product/**").hasRole("Admin")
    //.antMatchers(HttpMethod.DELETE, "/product/**").hasRole("Admin")
   // .and()
    //.csrf().disable()
    //.formLogin().disable();
}
}
