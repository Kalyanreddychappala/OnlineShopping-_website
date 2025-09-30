package org.in.apigw.filter;


import org.in.apigw.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;
@Component
public class RequestFilter implements GatewayFilter {
	@Autowired
	private JwtUtils jwtUtils;
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request=exchange.getRequest();
		String path=request.getURI().getPath();
		
		if(path.contains("/register")||path.contains("/login")) {
			return chain.filter(exchange);
		}
		
		
		HttpHeaders headers=request.getHeaders();
		String authHeader=headers.getFirst(HttpHeaders.AUTHORIZATION);
		
		if(authHeader==null||!authHeader.trim().startsWith("Bearer ")) {
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			return exchange.getResponse().setComplete();
		}
		
		String token=authHeader.substring(7).trim();
		
		try {
			Claims claims=jwtUtils.validateToken(token);
			System.out.println("Jwt Valid user: "+claims.getSubject());
			return chain.filter(exchange);
		}catch (Exception e) {
			// TODO: handle exception
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			return exchange.getResponse().setComplete();
		}
		
		
	}

}
