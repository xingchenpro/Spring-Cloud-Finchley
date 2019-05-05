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

    //配置资源服务
    //@Configuration
    //@EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            //资源访问控制，可配置必须通过token认证过后才可以访问的资源，permitAll()表示不需要token可直接访问
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

        //配置将Token存储到内存
        private TokenStore tokenStore = new InMemoryTokenStore();
        //配置将Token存储到数据库
        //JdbcTokenStore tokenStore=new JdbcTokenStore(dataSource);

        //配置开启密码类型的验证，只有配置了才会开启
        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Autowired
        private UserService userServiceDetail;

        //配置客户端的基本信息
        @Override
        //配置客户端信息
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

            String finalSecret = new BCryptPasswordEncoder().encode("123456");

            clients.inMemory()
                    //客户端Id，在Authorization Server 是唯一的
                    .withClient("client-service")
                    //认证类型
                    //客户端模式
                    .authorizedGrantTypes("client_credentials", "password","refresh_token")
                    //权限范围
                    .scopes("server")
                    //权限信息
                    .authorities("oauth2")
                    //客户端密码
                    .secret(finalSecret)
                    //密码模式
                    .and().withClient("client_2")
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("server")
                    .authorities("oauth2")
                    .secret(finalSecret)
                    .accessTokenValiditySeconds(2*3600);//2小时过期
        }

        @Override
        //配置Token节点的安全策略
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
            endpoints
                    .tokenStore(tokenStore)//Token的存储方式
                    //.tokenStore(new RedisTokenStore(redisConnectionFactory))
                    .authenticationManager(authenticationManager)//开启密码类型的验证
                    .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                    //配置读取用户验证信息，获取用户认证信息的接口
                    .userDetailsService(userServiceDetail);
            //endpoints.reuseRefreshTokens(true);
        }


        @Override
        //配置授权Token的节点和Token服务
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
            //配置获取Token的策略,允许表单认证，配置之后可通过表单获取Token
            oauthServer.allowFormAuthenticationForClients();
        }
    }
}
