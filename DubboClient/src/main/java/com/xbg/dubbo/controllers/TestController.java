package com.xbg.dubbo.controllers;

import com.jddglobal.ac.api.AcAuthAgent;
import com.jddglobal.uc.api.UcUserAgent;
import com.xbg.dubbo.dto.ItemClass;
import com.xbg.dubbo.pojo.DubboConsumerApi;
import com.xbg.dubbo.service.TestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/test")
public class TestController {

    //@Autowired(required = false)
    @DubboReference(check = false)
    private TestService testService;

    @DubboReference(check = false)
    private UcUserAgent acAuthAgent;

    @Autowired
    private DubboConsumerApi dubboConsumerApi;

    @GetMapping("/hello")
    public String hello(String name){

        return testService.sayHello(name);
    }

    @GetMapping("/helloapi")
    public String helloApi(String name) {
        TestService service = dubboConsumerApi.getService(TestService.class);
        return service.sayHello(name);
    }

    @GetMapping("/list")
    public List<ItemClass> getList(){
        return testService.getList();
    }



    public boolean isValidUUID(String uuid) {
        // UUID校验
        if (uuid == null) {
            System.out.println("uuid is null");
        }
        String regex = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";
        if (uuid.matches(regex)) {
            return true;
        }
        return false;
    }
}
