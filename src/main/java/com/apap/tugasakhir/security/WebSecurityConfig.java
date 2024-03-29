package com.apap.tugasakhir.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/user/**").permitAll()
			.antMatchers("/rawat-jalan/poli/jadwal/dokter-available").permitAll()
			.antMatchers("/rawat-jalan/pasien/**").permitAll()
			.antMatchers("/rawat-jalan/pasien/penanganan").permitAll()
			.antMatchers("/staff/**").hasAnyAuthority("ROLE_STAFF")
			.antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
			.antMatchers("/rawat-jalan/poli/jadwal").permitAll()
			.antMatchers("/rawat-jalan/poli/jadwal/**").hasAnyAuthority("ROLE_ADMIN")
			.antMatchers("/rawat-jalan/poli").permitAll()
			.antMatchers("/rawat-jalan/poli/**").hasAnyAuthority("ROLE_ADMIN")
			.antMatchers("/rawat-jalan/poli/jadwal").permitAll()
			.antMatchers("/rawat-jalan/poli/jadwal/**").hasAnyAuthority("ROLE_ADMIN")
			.anyRequest().authenticated()
			.and().formLogin().successHandler(successHandler)
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
			.permitAll();
	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}
		
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
