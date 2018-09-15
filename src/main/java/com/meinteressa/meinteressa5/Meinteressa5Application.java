package com.meinteressa.meinteressa5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;

@SpringBootApplication
public class Meinteressa5Application {

    public static void main(String[] args) {
        SpringApplication.run(Meinteressa5Application.class, args);
    }

    @Bean
    public DefaultConversionService mvcConversionService(){
        DefaultConversionService conversionService = new DefaultConversionService();

        DateFormatterRegistrar registrar = new DateFormatterRegistrar();

        registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));

        registrar.registerFormatters((FormatterRegistry) conversionService);

        return  conversionService;
    }
}
