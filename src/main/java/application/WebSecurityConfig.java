// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// import org.springframework.http.HttpMethod;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @EnableWebSecurity
@Component
public class WebSecurityConfig implements Filter { //extends WebSecurityConfigurerAdapter {
  
    @Override
    public void destroy() {
        System.out.println("destroy filter. release our resources here if any");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
                                                                                              IOException,ServletException {
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        httpServletResponse.setHeader("X-Content-Type-Options","nosniff");
        httpServletResponse.setHeader("X-Content-Type-Options","");
        chain.doFilter(request, response);      // continue execution of other filter chain.
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init filter");
    }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//                 .anonymous().authorities("ROLE_ANONYMOUS")
//                 .and()
//                 .authorizeRequests()
//                 .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                 .antMatchers(HttpMethod.GET,"/login/**").permitAll();
//         http.csrf().disable()
//             .anonymous()
//             .authorities("ROLE_ANONYMOUS")
//             .and()
//             .authorizeRequests()            
//             .antMatchers("/").permitAll()
//             .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//             .antMatchers(HttpMethod.GET, "/login/**").permitAll()
//             .anyRequest().authenticated()
//             .and()
//             .formLogin().loginPage("/login").permitAll()
//             .and()
//             .headers()
//             .cacheControl();
//         http.formLogin().disable();
//     }
}
