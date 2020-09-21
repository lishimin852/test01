package com.crow;

import com.crow.domain.Student;
import com.crow.service.StudentService;
import com.crow.service.impl.StudentServiceImpl;
import com.crow.utils.ServiceFactory;

import java.util.List;
public class Test {
    @org.junit.Test
    public void testSelectAllStudent() {
        StudentService service = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        List<Student> studentList = service.selectAllStudent();
        for (Student student : studentList) {
            System.out.println("查询的结果为" + student);
        }
    }
}
