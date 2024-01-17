package com.zhangziwa.practisesvr.service.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.zhangziwa.practisesvr.mapper.StudentsMapper;
import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.service.StudentService;
import com.zhangziwa.practisesvr.utils.http.RequestIUtils;
import com.zhangziwa.practisesvr.utils.pagehelper.PageHeaderUtils;
import com.zhangziwa.practisesvr.utils.pagehelper.PageUtils;
import com.zhangziwa.practisesvr.utils.response.ResponseContext;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Students)表服务实现类
 *
 * @author makejava
 * @since 2024-01-16 12:23:02
 */
@Service("studentsService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentsMapper studentsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer id) {
        return this.studentsMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param student    筛选条件
     * @return 查询结果
     */
    @Override
    public List<Student> queryByPage(Student student,Integer pageNum,Integer pageSize) {
        PageMethod.startPage(PageUtils.getPageNum(pageNum), PageUtils.getPageSize(pageSize), PageUtils.isQueryTotalCount());
        PageMethod.orderBy("id asc");

        List<Student> students = studentsMapper.queryAllByLimit(student);
        PageInfo<Student> studentPageInfo = PageInfo.of(students);

        PageHeaderUtils.setPageHeader(studentPageInfo);
        ResponseContext.setResponseCode(HttpStatus.OK);
        return students;
    }

    @Override
    public Long queryCount(Student student) {
        return this.studentsMapper.count(student);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentsMapper.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student student) {
        Map<String, Object> requestBody = RequestIUtils.getRequestBodyBody();

        Student stu = new Student();
        stu.setId(student.getId());
        stu.setUsername(student.getUsername());
        stu.setPassword(student.getPassword());
        stu.setAge(student.getAge());
        stu.setHeight(student.getHeight());
        stu.setGender(student.getGender());
        if (requestBody.containsKey("classId")){
            stu.setClassId(student.getClassId());
        }
        stu.setIsDelete(student.getIsDelete());

        this.studentsMapper.update(student);
        return this.queryById(student.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.studentsMapper.deleteById(id) > 0;
    }
}
