package bdbt_project.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()

                .antMatchers("/main").authenticated()
                .antMatchers("/pracownicy").authenticated()
                .antMatchers("/okazy").authenticated()
                .antMatchers("/bilety").authenticated()
                .antMatchers("/zbiorniki").authenticated()

                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/pracownicy_admin").access("hasRole('ADMIN')")
                .antMatchers("/okazy_admin").access("hasRole('ADMIN')")
                .antMatchers("/bilety_admin").access("hasRole('ADMIN')")
                .antMatchers("/zbiorniki_admin").access("hasRole('ADMIN')")

                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/pracownicy_user").access("hasRole('USER')")
                .antMatchers("/okazy_user").access("hasRole('USER')")
                .antMatchers("/bilety_user").access("hasRole('USER')")
                .antMatchers("/zbiorniki_user").access("hasRole('USER')")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();
    }
}