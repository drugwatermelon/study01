package hxyk.zh.study.repository;


import hxyk.zh.study.domain.Student;
import java.util.List;

/**
 * Created by Administrator on 2017-2-23.
 */
public interface StudentRepository {
    Student findStudent(Long id);
    List<Student> findAll();
    void modify(Student student);
    void add(Student student);
//    public void add(Order order);
    void deleteStudent(Long id);
}
