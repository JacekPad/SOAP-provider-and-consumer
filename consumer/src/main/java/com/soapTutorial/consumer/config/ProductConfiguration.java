package com.soapTutorial.consumer.config;

import com.soapTutorial.consumer.service.ProductConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ProductConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        path from .pom generatePackage
        marshaller.setContextPath("com.soapTutorial.consumer.model");
        return marshaller;
    }

    @Bean
    public ProductConsumer productConsumer(Jaxb2Marshaller marshaller) {
        ProductConsumer consumer = new ProductConsumer();
        consumer.setDefaultUri("http://localhost:8080/ws");
        consumer.setMarshaller(marshaller);
        consumer.setUnmarshaller(marshaller);
        return consumer;
    }

}
