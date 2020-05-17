/**  
* @Title: SecurityConfig.java  
* @Package com.dt.config  
* @Description: TODO(用一句话描述该文件做什么)  
* @author jxZhang  
* @date 2020年1月6日  
* @version V1.0  
*/  
package com.dt.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**  
* @ClassName: SecurityConfig  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author jxZhang  
* @date 2020年1月6日  
*    
*/
@Configuration
//@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

    }

}
