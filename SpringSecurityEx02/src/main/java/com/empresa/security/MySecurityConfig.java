package com.empresa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	
	// Sou obrigado a colocar a anotação @Bean pois o métodos securityFilterChain vai retornar
	// um objeto com a regras de dos filtors de Segurança
	// securityFilterChain faz a liberções e bloqueios de endpoints indicando o filtro que realizará esse tratamento
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() // Desabilita o csrf, porque nósa vamos tratar a autenticação dos usuários
		.authorizeHttpRequests() // Agora as requisições http são passíveis de autorização
		.requestMatchers(HttpMethod.GET,"/free").permitAll() // Liberando o GET em /free para todos (não autenticado)
		.anyRequest().authenticated().and().cors(); // Qualquer outras URLs são autenticadas e soferão as restrições dos CORS
		
		http.addFilterBefore(new MyFilter(), UsernamePasswordAuthenticationFilter.class); // Adciona um filtro antes
		
		return http.build();
	}
}
