package br.com.auth.serv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import br.com.auth.serv.commons.AuthorizationServerConstants;

@Configuration
@EnableAuthorizationServer
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {
	
	@Value("${client.application.id}")
	private String clientId;
	
	@Value("${client.application.secret}")
	private String clientSecret;
	
	@Value("${client.resource.id}")
	private String resourceId;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
			.tokenKeyAccess(AuthorizationServerConstants.PERMIT_ALL_ACCESS)
			.checkTokenAccess(AuthorizationServerConstants.IS_AUTHENTICATED_ACCESS);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient(clientId)
				.authorizedGrantTypes(AuthorizationServerConstants.PASSWORD_GRUNT_TYPE,
						AuthorizationServerConstants.REFRESH_TOKEN_GRUNT_TYPE)
				.authorities(AuthorizationServerConstants.USER_AUTHORITIE)
				.scopes(AuthorizationServerConstants.READ_SCOPE,
						AuthorizationServerConstants.WRITE_SCOPE)
				.resourceIds(resourceId)
				.secret(clientSecret);
	}
	
}
