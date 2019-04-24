package com.hly.oauthservice.config;

import com.hly.oauthservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import javax.sql.DataSource;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/20
 */

@Configuration
public class OAuth2ServerConfig {

    //资源服务
    //@Configuration
    //@EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            //访问控制，必须通过token认证过后才可以访问
            http
                    .authorizeRequests()
                    .antMatchers("/login").permitAll();
        }
    }

    //授权服务
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        //@Autowired
        //@Qualifier("dataSource")
        private DataSource dataSource;

        private TokenStore tokenStore = new InMemoryTokenStore();

        //JdbcTokenStore tokenStore=new JdbcTokenStore(dataSource);

        //配置开启密码类型的验证
        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Autowired
        private UserService userServiceDetail;

        //配置客户端的基本信息
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

            String finalSecret = new BCryptPasswordEncoder().encode("123456");

            clients.inMemory()
                    .withClient("client_1")
                    //客户端模式
                    //.resourceIds(ARTICLE_RESOURCE_ID,VIDEO_RESOURCE_ID)
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    .scopes("select")//权限范围
                    .authorities("oauth2")
                    .secret(finalSecret)
                    //密码模式
                    .and().withClient("client_2")
                    //.resourceIds(ARTICLE_RESOURCE_ID,VIDEO_RESOURCE_ID)
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("server")
                    .authorities("oauth2")
                    .secret(finalSecret)
                    .accessTokenValiditySeconds(2*3600);//2小时过期
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
            endpoints
                    .tokenStore(tokenStore)//Token的存储方式
                    //.tokenStore(new RedisTokenStore(redisConnectionFactory))
                    .authenticationManager(authenticationManager)//开启密码类型的验证
                    .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                    .userDetailsService(userServiceDetail);//配置读取用户验证信息
            //endpoints.reuseRefreshTokens(true);
        }

        //配置获取Token的策略
        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
            //允许表单认证
            oauthServer.allowFormAuthenticationForClients();
           /* oauthServer
                    .tokenKeyAccess("permitAll()")
                    .checkTokenAccess("isAuthenticated()");*/
        }
    }
}
