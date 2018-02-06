package com.company.Handler;

import com.company.loader.MClassLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SummatorHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MClassLoader classLoader = new MClassLoader();
        Object summator = null;
        try {
            summator = classLoader
                    .loadClass("com.company.Summator")
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return method.invoke(summator, args);
    }
}
