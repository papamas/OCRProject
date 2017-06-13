package com.proyekOCR.springmvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static String REALM="Authentication proyekOCR";
	
        @Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	PersistentTokenRepository tokenRepository;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}
        
        
        @Configuration
        @Order(1)
        public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter{        
            @Override        
            protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .antMatcher("/api/**")
                    .authorizeRequests()
                        .anyRequest().fullyAuthenticated()
                        .and()
                    .httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint());                                
            }
            
            @Bean
            public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
		return new CustomBasicAuthenticationEntryPoint();
            }
        }
        
        @Configuration
        @Order(2)
        public static class FormWebSecurityConfig extends WebSecurityConfigurerAdapter{            
            @Override
            public void configure(WebSecurity web) throws Exception {            
                web.ignoring().antMatchers("/static/**");
            }

            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable() //HTTP with Disable CSRF
                    .authorizeRequests() //Authorize Request Configuration
                        .antMatchers("/registration").permitAll()
                        .anyRequest().authenticated()
                        .and() //Login Form configuration for all others
                    .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password")
                        .permitAll()
                        .and() //Logout Form configuration
                    .logout().permitAll();
            }
        }
        
       
       
        /*
        
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
            
            //http.authorizeRequests()
                                /*
                                .antMatchers("/", "/home")
				.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
				.antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')").antMatchers("/edit-user-*")
				.access("hasRole('ADMIN') or hasRole('DBA')")
                                */
                                /*
                                .antMatchers("/static/**", "/registration").permitAll()
                                .anyRequest().authenticated()
                                .and()
                                .httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
                                .and()
                        .formLogin().loginPage("/login")
				.loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password")
                                .permitAll()
                                .and()
				.rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
				.tokenValiditySeconds(86400).and()
                                .csrf().disable()
                                .exceptionHandling().accessDeniedPage("/Access_De  nied")
                                .and()
                        .logout()
                           .permitAll();
                        
	}

        */
        
        

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
				"remember-me", userDetailsService, tokenRepository);
		return tokenBasedservice;
	}

	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}

}
