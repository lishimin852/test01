package com.crow.service.impl;

import com.crow.dao.StudentDao;
import com.crow.domain.Student;
import com.crow.service.StudentService;
import com.crow.utils.UtilSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    SqlSession sqlSession = UtilSqlSession.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);


    @Override
    public List<Student> selectAllStudent() {
        List<Student> studentList = dao.selectAllStudent();
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        dao.addStudent(student);
    }
}
