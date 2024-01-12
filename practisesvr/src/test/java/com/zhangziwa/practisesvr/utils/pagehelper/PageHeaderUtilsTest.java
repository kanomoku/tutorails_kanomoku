package com.zhangziwa.practisesvr.utils.pagehelper;

import com.github.pagehelper.Page;
import com.zhangziwa.practisesvr.model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PageHeaderUtilsTest {

    @Test
    public void manualPage() {
        List<Student> students = new ArrayList<Student>();
        Page<Student> objects = PageHeaderUtils.manualPage(students, 1, 10);
        System.out.println(objects);
    }
}