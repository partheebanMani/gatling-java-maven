package com.load.test.propsconverter;

import com.load.test.TestEnv;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class TestEnvConverter implements Converter<TestEnv> {
    @Override
    public TestEnv convert(Method method, String s) {
        return TestEnv.valueOf(s.toUpperCase());
    }
}
