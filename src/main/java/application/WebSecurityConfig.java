import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.http.HttpMethod;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//                 .anonymous().authorities("ROLE_ANONYMOUS")
//                 .and()
//                 .authorizeRequests()
//                 .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                 .antMatchers(HttpMethod.GET,"/login/**").permitAll();
        http.csrf().disable()
            .anonymous()
            .authorities("ROLE_ANONYMOUS")
            .and()
            .authorizeRequests()            
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .antMatchers(HttpMethod.GET, "/login/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login").permitAll()
            .and()
            .headers()
            .cacheControl();
        http.formLogin().disable();
    }
}
