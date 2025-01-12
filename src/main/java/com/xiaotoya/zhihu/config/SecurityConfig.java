package com.xiaotoya.zhihu.config;

import com.xiaotoya.zhihu.common.Constant;
import com.xiaotoya.zhihu.exception.CustomAccessDeniedHandler;
import com.xiaotoya.zhihu.exception.CustomAuthenticationEntryPoint;
import com.xiaotoya.zhihu.exception.CustomAuthenticationFailureHandler;
import com.xiaotoya.zhihu.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 注入验证对象
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    // 配置请求路由放行
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 关闭csrf
        http.csrf(AbstractHttpConfigurer::disable);
        // 放行登录
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers(Constant.LOGIN_PATH)
                        .permitAll()
                        .anyRequest()
                        .authenticated()

        );
        http.formLogin(configure -> configure.failureHandler(customAuthenticationFailureHandler));
        http.exceptionHandling(configure -> {
            configure.accessDeniedHandler(accessDeniedHandler);
            configure.authenticationEntryPoint(customAuthenticationEntryPoint);
        });
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
