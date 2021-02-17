package com.xbg.test;

import com.xbg.dubbo.ServerApplication;
import com.xbg.dubbo.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ServerApplication.class)
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void testBean(){
        String ddd = testService.sayHello("ddd");
    }
}
