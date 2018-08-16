package com.teleware;

import com.teleware.filter.FirstFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;

import com.teleware.filter.ErrorFilter;
import com.teleware.filter.ResultFilter;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}


	@Bean
	public FirstFilter firstFilter() {
		return new FirstFilter();
	}

	@Bean
	public ResultFilter resultFilter() {
		return new ResultFilter();
	}


	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}


	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		List<String> origins = new ArrayList<>();
		origins.add("*");
		config.addAllowedOrigin("*");
		List<String> headers = new ArrayList<>();
		headers.add("*");
		config.addAllowedHeader("*");
		List<String> methods = new ArrayList<>();
		methods.add("*");
		methods.add("GET");
		methods.add("POST");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
