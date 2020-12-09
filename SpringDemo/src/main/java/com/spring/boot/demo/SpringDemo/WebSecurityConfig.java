package com.spring.boot.demo.SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService) // Cung cáp userservice cho spring security
                .passwordEncoder(passwordEncoder()); // cung cấp password encoder
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                //.antMatchers("/all-questions/**").hasAnyAuthority("ROLE_LECTURER", "ROLE_MANAGER")
//                .antMatchers("/all-subjects").hasAnyAuthority("LECTURER", "MANAGER")
//                .antMatchers("/all-employees**").hasAuthority("MANAGER")
//                .antMatchers("/all-managers**").hasAuthority("MANAGER")
//                .antMatchers("/all-lecturers**").hasAuthority("MANAGER")
                .antMatchers("/all-accounts**").hasAnyAuthority("MANAGER")
                .antMatchers("/all-students**").hasAnyAuthority("MANAGER")
                .antMatchers("/all-questions**").hasAnyAuthority("LECTURER", "MANAGER")
                .antMatchers("/all-subjects").hasAnyAuthority("STUDENT", "LECTURER", "MANAGER")
                .antMatchers("/all-exams").hasAnyAuthority("LECTURER");

        // Thêm một lớp Filter kiểm tra jwt
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
