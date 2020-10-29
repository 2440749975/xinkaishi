package com.usian.service;

import com.usian.mapper.StudentMapper;
import com.usian.pojo.Student;
import com.usian.pojo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public void addStudent(Student student) {
       studentMapper.insert(student);
    }
//
    public List<StudentVo> findAll(StudentVo student) {
        return studentMapper.findAll(student);
    }
//
    public Student findByid(Integer sid) {
        return  studentMapper.selectByPrimaryKey(sid);
    }
//
    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }
//
    public void delete(Integer sid) {
        studentMapper.deleteByPrimaryKey(sid);
    }

    public Student login(Student student) {
        return studentMapper.selectByname(student);
    }

    public Student findByadd(String sname) {
        return studentMapper.findByadd(sname);
    }
}
