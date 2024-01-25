package com.zhangziwa.practisesvr.utils.holder;

import com.zhangziwa.practisesvr.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.apache.commons.lang3.ObjectUtils.anyNull;

public class StudentContextHolder {
    private static final ThreadLocal<Map<Integer, Student>> studentContextHolder = ThreadLocal.withInitial(HashMap::new);

    public static Student getStudent(Integer id) {
        if (Objects.isNull(id)) {
            return null;
        }
        return studentContextHolder.get().get(id);
    }

    public static void setStudent(Integer id, Student student) {
        if (anyNull(id, student)) {
            return;
        }
        if (getStudent(id) != null) {
            throw new UnsupportedOperationException("Student with id " + id + " already exists.");
        }
        studentContextHolder.get().put(id, student);
    }

    public static void clear() {
        studentContextHolder.remove();
    }
}
