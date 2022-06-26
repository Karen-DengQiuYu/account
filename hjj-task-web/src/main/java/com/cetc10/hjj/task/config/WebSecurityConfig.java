package com.cetc10.hjj.task.config;

import com.cetc10.hjj.task.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginUserService loginUserService;

    /**
     * 指定加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }

    private static final String[] AUTH_WHITELIST = {
            "/static/js/**",
            "/static/css/**",
            "/static/images/**",
            "/static/fonts/**",
            "/static/ueditor/**",
            "/webjars/**",
            "/registration**",
            "/register**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
//                .loginPage("/static/lyear_pages_login.html")   //自定义登录页面
                .and()
                .authorizeRequests() // 允许放行
                .antMatchers(AUTH_WHITELIST).permitAll()
//             .antMatchers("/get").permitAll()
                .anyRequest().authenticated()  // 所有请求需要身份认证
                .and()
                .cors()  //支持跨域
                .and()
                .logout().logoutUrl("/logout")  //默认就是"/logout"
                //关闭防火墙：为了保证完整流程可用关闭CSRF安全协议
                .and()
                .csrf().disable()
                .sessionManagement()
                .invalidSessionUrl("/invalid");  // 设置session过期 跳转页面

    }

    /**
     * 该方法是登录的时候会进入
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 从数据库读取的用户进行身份认证
                .userDetailsService(loginUserService)
                .passwordEncoder(passwordEncoder());
    }
}
