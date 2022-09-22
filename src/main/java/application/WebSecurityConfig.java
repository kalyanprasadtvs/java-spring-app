import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
        .anonymous()
            .authorities("ROLE_ANONYMOUS")
            .and()
        .headers()
             .cacheControl()
             .and()
        .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/profile/image").permitAll()
            .antMatchers("/favicon.ico").permitAll()
            .antMatchers("/resources/**").permitAll()

            .antMatchers(HttpMethod.GET, "/login/**").permitAll()

            .anyRequest().authenticated();
    }
}
