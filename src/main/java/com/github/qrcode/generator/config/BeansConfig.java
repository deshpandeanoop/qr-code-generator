package com.github.qrcode.generator.config;

import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

@Configuration
public class BeansConfig {

    @Bean
    public QRCodeWriter qrCodeWriter(){
        return new QRCodeWriter();
    }

    @Bean
    public HttpMessageConverter<BufferedImage> bufferedImageHttpMessageConverter(){
        return new BufferedImageHttpMessageConverter();
    }
}
