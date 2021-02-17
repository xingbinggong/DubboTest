package com.xbg.dubbo.dubbofilter;

import org.apache.dubbo.rpc.*;

import java.lang.reflect.Field;
import java.util.List;

public class ListFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = invoker.invoke(invocation);	// 进行服务调用

        if(result.getValue() instanceof List){
            List list = (List) result.getValue();
            for(int i=list.size()-1;i>=0;i--){
                Object o = list.get(i);
                Object nameVal = this.getValue(o,"name");
                if ("AAA".equals(nameVal)){
                    list.remove(i);
                }
            }
        }

        return result;
    }

    private Object getValue(Object o,String fieldName){
        try {
            Field field = o.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            try {
                Object o1 = field.get(o);
                return o1;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
