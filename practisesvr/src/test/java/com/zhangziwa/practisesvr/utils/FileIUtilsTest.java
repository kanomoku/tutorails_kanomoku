package com.zhangziwa.practisesvr.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileIUtilsTest {

    @Test public void genFileName() {
        String fileName = FileIUtils.genFileName("/example/", "test", "txt");
        System.out.println(fileName);
    }
}