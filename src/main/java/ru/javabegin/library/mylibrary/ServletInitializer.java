package ru.javabegin.library.mylibrary;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//С помощью этих аннотаций мы создаем web-проект на Spring
@SpringBootApplication
// @ComponentScan(basePackages = {"ru.javabegin.training.library"}) уже не требуется указывать, говорит с какого паке искать бины
public class ServletInitializer extends SpringBootServletInitializer {

}

