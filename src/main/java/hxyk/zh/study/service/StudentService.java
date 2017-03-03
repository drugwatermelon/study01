package hxyk.zh.study.service;

import hxyk.zh.study.domain.Student;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2017-2-23.
 */
public interface StudentService {
    Student getStudent(Long id);
    List<Student> getStudents();
    void updateStudent(Student student);
    void addStudent(Student student);
//    void addOrder(Order order);
    void deleteS(Long id);
    Page<Student> getStudents(int page);
}
