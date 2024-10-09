package com.alten.configuration;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("methodAndParamsKeyGenerator")
public class CustomKeyGenerator implements KeyGenerator {

    public static final String KEY_GENERATOR_NAME = "methodAndParamsKeyGenerator";

    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        sb.append(target.getClass().getSimpleName()).append('-').append(method.getName());
        for (Object param : params) {
            if (param != null) {
                sb.append("-").append(param.getClass().getSimpleName()).append(':').append(param);
            }
        }
        return sb.toString();
    }
}
