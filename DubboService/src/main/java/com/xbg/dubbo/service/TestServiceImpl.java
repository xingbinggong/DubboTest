package com.xbg.dubbo.service;

import com.xbg.dubbo.dto.ItemClass;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService {

    public String sayHello(String name) {
        return "Hello "+name;
    }

    @Override
    public List<ItemClass> getList() {
        List<ItemClass> list = new ArrayList<>();

        ItemClass itemA = new ItemClass();
        itemA.setName("AAA");

        ItemClass itemb = new ItemClass();
        itemb.setName("BBB");

        list.add(itemA);
        list.add(itemb);

//        for(int i=0;i<50;i++){
//            ItemClass item = new ItemClass();
//            item.name="name"+i;
//            item.desc="the "+i+" desc";
//            list.add(item);
//        }
        return list;
    }
}
