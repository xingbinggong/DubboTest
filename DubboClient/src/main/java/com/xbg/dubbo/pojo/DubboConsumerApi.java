package com.xbg.dubbo.pojo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class DubboConsumerApi {

    @Value("${dubbo.application.name}")
    private String appName;

    @Value("${dubbo_api.address}")
    private String address;

    private ConcurrentMap<Class,Object> references = new ConcurrentHashMap<>();


    public <T> T getService(Class<T> serviceApi) {

        if (references.containsKey(serviceApi)) {
            return (T)references.get(serviceApi);
        }

        // 当前应用配置
//        ApplicationConfig application = new ApplicationConfig();
//        application.setName(appName);

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(address);

        // 引用远程服务
        // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        ReferenceConfig<T> reference =  new ReferenceConfig<T>();
        //reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(serviceApi);

        T obj = reference.get();
        references.put(serviceApi,obj);

        return obj;
    }
}
