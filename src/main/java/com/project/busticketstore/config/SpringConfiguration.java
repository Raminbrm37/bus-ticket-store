package com.project.busticketstore.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public ModelMapper createModelMapper(){
        return new ModelMapper();
    }
}
