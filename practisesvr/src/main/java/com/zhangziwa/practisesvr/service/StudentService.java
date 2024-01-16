package com.zhangziwa.practisesvr.service;

import com.zhangziwa.practisesvr.model.Student;

import java.util.List;

/**
 * (Students)表服务接口
 *
 * @author makejava
 * @since 2024-01-16 12:23:01
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);

    /**
     * 分页查询
     *
     * @param student 筛选条件
     * @return 查询结果
     */
    List<Student> queryByPage(Student student, Integer pageNum, Integer pageSize);

    Long queryCount(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
