package com.poronitay.etupirka;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.Getter;

@SpringBootApplication
public class EtupirkaApplication {

    @Getter
    private static ApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(EtupirkaApplication.class, args);
		Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
	}



}
