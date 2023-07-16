package com.stream.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.stream.eduservice.mapper")
public class EduConfig {
    
}
