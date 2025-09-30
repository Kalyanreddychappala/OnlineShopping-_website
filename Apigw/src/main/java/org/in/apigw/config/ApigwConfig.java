package org.in.apigw.config;

import org.in.apigw.filter.RequestFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class ApigwConfig {
	@Value("${registration.url}")
	private String registrationUrl;
	@Value("${login.url}")
	private String loginUrl;
	@Value("${product.register}")
	private String productRegister;
	@Value("${product.get}")
	private String productGet;
	@Value("${product.getAll}")
	private String productGetAll;
	@Value("${add.cart}")
	private String addCart;
	@Value("${get.cart}")
	private String getCart;
	@Value("${delete.cart}")
	private String deleteCart;
	@Value("${create.order}")
	private String createOrder;
	@Value("${get.user.id}")
	private String getUserId;
	@Value("${get.items}")
	private String getItems;
	@Value("${process.payment}")
	private String processPayment;
	@Value("${get.payment}")
	private String getPayment;
	@Value("${update.payment}")
	private String updatePayment;
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder,RequestFilter requestFilter) {
		return builder.routes()
				//register
				.route("registration",r->r.path("/register")
				.and().method(HttpMethod.POST)
				.uri(registrationUrl))
				
				//login
				.route("login",r->r.path("/login")
						.and().method(HttpMethod.POST)
						.uri(loginUrl))
				//product
				.route("productRegistration",r->r.path("/products")
						.and().method(HttpMethod.POST)
						.filters(f->f.filter(requestFilter))
						.uri(productRegister))
				.route("productGet",r->r.path("/product/*")
						.and().method(HttpMethod.GET)
						.filters(f->f.filter(requestFilter))
						.uri(productGet))
				.route("ProductGetAll",r->r.path("/productGetAll")
						.and().method(HttpMethod.GET)
						.filters(f->f.filter(requestFilter))
						.uri(productGetAll))
				
				//shopping_cart
				.route("addcart",r->r.path("/cartadd")
						.and().method(HttpMethod.POST)
						.filters(f->f.filter(requestFilter))
						.uri(addCart))
				.route("getcart",r->r.path("/cart/*")
						.and().method(HttpMethod.GET)
						.filters(f->f.filter(requestFilter))
						.uri(getCart))
				.route("deletecart",r->r.path("/delete/*")
						.and().method(HttpMethod.DELETE)
						.filters(f->f.filter(requestFilter))
						.uri(deleteCart))
				
				//order
				.route("createOrder",r->r.path("/create")
						.and().method(HttpMethod.POST)
						.filters(f->f.filter(requestFilter))
						.uri(createOrder))
				.route("GetUserID",r->r.path("/user/*")
						.and().method(HttpMethod.GET)
						.filters(f->f.filter(requestFilter))
						.uri(getUserId))
				.route("Getitems",r->r.path("/items")
						.and().method(HttpMethod.DELETE)
						.filters(f->f.filter(requestFilter))
						.uri(getItems))
				
				//payment
				.route("processPayment",r->r.path("/payments")
						.and().method(HttpMethod.POST)
						.filters(f->f.filter(requestFilter))
						.uri(processPayment))
				.route("getPayment",r->r.path("/payment/*")
						.and().method(HttpMethod.GET)
						.filters(f->f.filter(requestFilter))
						.uri(getPayment))
				.route("updatePayment",r->r.path("/paymentUpdate/*")
						.and().method(HttpMethod.PUT)
						.filters(f->f.filter(requestFilter))
						.uri(updatePayment))
				.build();
		
		
	}
}
