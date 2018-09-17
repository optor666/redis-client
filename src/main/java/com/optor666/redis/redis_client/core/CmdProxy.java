package com.optor666.redis.redis_client.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by optor666 on 2018/6/28.
 */
public class CmdProxy implements InvocationHandler {

    private Cmd cmd;

    public CmdInterface bind(Cmd cmd) {
        this.cmd = cmd;
        return (CmdInterface) Proxy.newProxyInstance(cmd.getClass().getClassLoader(), cmd.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object res = method.invoke(cmd, args);
        long endTime = System.currentTimeMillis();
        StringBuilder argsSb = new StringBuilder();
        if (args != null && args.length > 0) {
            for (Object obj : args) {
                if (obj instanceof String) {
                    argsSb.append("\"");
                    argsSb.append(obj);
                    argsSb.append("\"");
                } else {
                    argsSb.append(obj);
                }
                argsSb.append(", ");
            }
        }
        if (argsSb.length() > 0) {
            argsSb.delete(argsSb.length() - 2, argsSb.length());
        }
        if (cmd.isLoggerSwitch()) {
            System.out.println("Exec " + method.getName() + " (" + argsSb + ") elapsed time: " + (endTime - startTime) + " ms");
        }
        return res;
    }
}
