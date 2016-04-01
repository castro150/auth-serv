package br.com.auth.serv;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import br.com.auth.serv.config.AuthServerOAuth2Config;

@SpringBootApplication
public class AuthServApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AuthServerOAuth2Config.class).run(args);
	}
}
