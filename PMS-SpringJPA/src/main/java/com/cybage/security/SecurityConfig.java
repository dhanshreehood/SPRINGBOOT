package com.cybage.security;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter{
public void configure(AuthenticationManagerBuilder auth) throws Exception
{
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

@Override
// Method
protected void configure(HttpSecurity http)
    throws Exception
{
    http.httpBasic()
    .and()
    .authorizeRequests()
        .antMatchers("/product/").permitAll()    //hasAnyRole("USER", "ADMIN")
        .antMatchers("/product/{id}").hasRole("ADMIN")
        .antMatchers("/product/Pageable").hasRole("ADMIN");
    //	.antMatchers("/admin").hasRole("ADMIN").and().csrf().disable();

    
   // .antMatchers(HttpMethod.PUT, "/product/**").hasRole("Admin")
    //.antMatchers(HttpMethod.PATCH, "/product/**").hasRole("Admin")
    //.antMatchers(HttpMethod.DELETE, "/product/**").hasRole("Admin")
   // .and()
    //.csrf().disable()
    //.formLogin().disable();
}
}
*/