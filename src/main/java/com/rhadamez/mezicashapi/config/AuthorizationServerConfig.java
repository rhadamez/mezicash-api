package com.rhadamez.mezicashapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.rhadamez.mezicashapi.security.AppUserDetailsService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AppUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("angular").secret("$2a$10$QWe8xjICuYjhMpr2D8WoGO/sAHS/T.A/RpqRaO6dWZXqjXqXuLr.C")
				.scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token")
				.accessTokenValiditySeconds(120).refreshTokenValiditySeconds(3600 * 24)
				.and()
				.withClient("mobile")
				.secret("$2a$10$eSV4KReUF/4VTXY5e8GWQOp2siD21gysuYmHou9vrNDyCZruxaSfS")
				.scopes("read")
				.authorizedGrantTypes("password", "refresh_token")
				.accessTokenValiditySeconds(120).refreshTokenValiditySeconds(3600 * 24);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter()).reuseRefreshTokens(false)
				.userDetailsService(this.userDetailsService).authenticationManager(authenticationManager);
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("rhadamez");

		return accessTokenConverter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

}
