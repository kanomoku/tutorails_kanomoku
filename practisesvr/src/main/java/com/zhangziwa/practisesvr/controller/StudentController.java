package com.zhangziwa.practisesvr.controller;

import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Students)表控制层
 *
 * @author makejava
 * @since 2024-01-16 12:22:55
 */
@RestController
@RequestMapping("students")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 分页查询
     *
     * @param student 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<Student>> queryByPage(Student student,
                                                     @RequestParam(value = "pageNum") Integer pageNum,
                                                     @RequestParam(value = "pageSize") Integer pageSize) {
        System.out.println("***StudentController.queryByPage***");
        return ResponseEntity.ok(studentService.queryByPage(student, pageNum, pageSize));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> queryCount(Student student) {
        System.out.println("***StudentController.queryCount***");
        return ResponseEntity.ok(studentService.queryCount(student));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Student> queryById(@PathVariable("id") Integer id) {
        System.out.println("***StudentController.queryById***");
        return ResponseEntity.ok(studentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param student 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student) {
        System.out.println("***StudentController.add***");
        return ResponseEntity.ok(studentService.insert(student));
    }

    /**
     * 编辑数据
     *
     * @param student 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Student> edit(@RequestBody Student student) {
        System.out.println("***StudentController.edit***");
        return ResponseEntity.ok(studentService.update(student));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        System.out.println("***StudentController.deleteById***");
        boolean body = studentService.deleteById(id);
        if (body) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

