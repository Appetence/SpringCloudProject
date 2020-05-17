package com.ztx.springcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;

/**
 * 资源服务器配置
 * Created by macro on 2019/9/30.
 */
@Order(6)
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)//注解方式认证
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {

    @Resource
    public TokenStore tokenStore;

    public static final String RESOURCE_ID = "res1";

    /*  @Override
      public void configure(ResourceServerSecurityConfigurer resources) {
          resources.resourceId(RESOURCE_ID).tokenServices(tokenService()).stateless(true);
      }*/
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).tokenStore(tokenStore).stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/oauth/authorize").permitAll()
                .antMatchers("/r/r1").hasAuthority("p2")
                .antMatchers("/r/r2").hasAuthority("p1")
                .antMatchers("/r/**").permitAll()
                .antMatchers("/**")
                .access("#oauth2.hasScope('all')")
                .anyRequest().authenticated()//除了/r/**，其它的请求可以访问
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }

    //资源服务令牌解析服务
/*    @Bean
    public ResourceServerTokenServices tokenService() {
        //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
        RemoteTokenServices service = new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://localhost:9401/oauth/check_token");
        service.setClientId("admin");
        service.setClientSecret("admin123456");
        return service;
    }*/

}