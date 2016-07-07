package com.zandroid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class DockerZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerZuulApplication.class, args);
	}
}
