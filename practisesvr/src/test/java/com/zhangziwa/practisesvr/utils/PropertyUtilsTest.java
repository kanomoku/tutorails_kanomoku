package com.zhangziwa.practisesvr.utils;

import org.junit.Assert;
import org.junit.Test;

public class PropertyUtilsTest {
    @Test
    public void testPropertyUtils() {
        Assert.assertEquals("key", PropertyUtils.getKey());
        Assert.assertEquals("value", PropertyUtils.getValue());
    }
}