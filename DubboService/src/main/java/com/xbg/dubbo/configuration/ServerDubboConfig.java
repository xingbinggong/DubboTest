package com.xbg.dubbo.configuration;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:dubbo/dubbo-provider.xml")
@DubboComponentScan("com.xbg.dubbo")
public class ServerDubboConfig {
}
