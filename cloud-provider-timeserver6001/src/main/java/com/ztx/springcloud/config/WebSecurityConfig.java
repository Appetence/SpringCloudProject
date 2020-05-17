package com.ztx.springcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 这里配置拦截不生效是由于用户信息存到token中所以此处拦截无效
     * @param http
     * @throws Exception
     */
    //安全拦截机制（最重要）
    @Override//安全拦截机制
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p2")
                .antMatchers("/r/r2").hasAuthority("p1")
                .antMatchers("/r/**").permitAll()
                .anyRequest().authenticated();//除了/r/**，其它的请求可以访问
    }
}