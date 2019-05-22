package com.springboot.craftsman.configuration.security;

import com.springboot.craftsman.component.MyUserDetailsService;
import com.springboot.craftsman.handler.MyAuthenticationFailHandler;
import com.springboot.craftsman.handler.MyAuthenticationSuccessHandler;
import com.springboot.craftsman.handler.MyLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security 配置类
 * Created by Zhengzy
 */
@EnableWebSecurity
//开启security注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BrowserSecurityConfig  extends WebSecurityConfigurerAdapter {

    /**
     * 注入 Security 属性类配置
     */
    @Autowired
    private SecurityProperties securityProperties;


    @Autowired
    private MyUserDetailsService userDetailsService;

    /**
     * 重写PasswordEncoder  接口中的方法，实例化加密策略
     * @return 返回 BCrypt 加密策略
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 注入 自定义的  登录成功处理类
     */
    @Autowired
    private MyAuthenticationSuccessHandler mySuccessHandler;

    @Autowired
    private MyAuthenticationFailHandler myFailHandler;

    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String redirectUrl = securityProperties.getBrowser().getLoginPage();
        //basic 登录方式
        // http.httpBasic()

        //表单登录 方式
        http.formLogin()
            .loginPage("/login").permitAll()
            //登录需要经过的url请求
            .loginProcessingUrl("/login").permitAll()
            .successHandler(mySuccessHandler)
            .failureHandler(myFailHandler)
            .and()
            .logout().permitAll().invalidateHttpSession(true)
            .deleteCookies("JSESSIONID").logoutSuccessHandler(myLogoutSuccessHandler)
            //.and().sessionManagement().maximumSessions(10).expiredUrl("/tologin")
            .and()
            //请求授权
            .authorizeRequests()
            //不需要权限认证的url
            .antMatchers("/login",redirectUrl).permitAll()
            .antMatchers("/static/**",redirectUrl).permitAll()
            //任何请求
            .anyRequest()
            //需要身份认证
            .authenticated()
            .and()
            //关闭跨站请求防护
            .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

}
