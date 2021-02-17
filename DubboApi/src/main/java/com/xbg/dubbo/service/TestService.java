package com.xbg.dubbo.service;

import com.xbg.dubbo.dto.ItemClass;

import java.util.List;

public interface TestService {
    String sayHello(String name);

    List<ItemClass> getList();
}
