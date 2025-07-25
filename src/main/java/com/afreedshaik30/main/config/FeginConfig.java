package com.afreedshaik30.main.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FeginConfig {
    @Bean
    public Encoder feginEncoder(){
        return new SpringFormEncoder(
                new SpringEncoder(()-> new HttpMessageConverters(new RestTemplate().getMessageConverters()))
        );
    }
}
