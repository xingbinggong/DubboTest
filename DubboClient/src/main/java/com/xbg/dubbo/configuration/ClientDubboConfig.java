package com.xbg.dubbo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:dubbo/dubbo-consumer.xml")
public class ClientDubboConfig {
}
