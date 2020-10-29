package com.usian.mapper;

import com.usian.pojo.Student;
import com.usian.pojo.StudentVo;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<StudentVo> findAll(StudentVo student);

    Student selectByname(Student student);

    Student findByadd(String sname);
}
