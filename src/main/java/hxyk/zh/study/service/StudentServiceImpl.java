package hxyk.zh.study.service;

import hxyk.zh.study.domain.Student;
import hxyk.zh.study.repository.StudentLimitRepository;
import hxyk.zh.study.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2017-2-23.
 */
@Service
@Slf4j
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentLimitRepository studentLimitRepository;

    @Override
    public Student getStudent(Long id) {
        return this.studentRepository.findStudent(id);
    }

    @Override
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public void updateStudent(Student student) {
        this.studentRepository.modify(student);
    }

    @Override
    public void addStudent(Student student) {
        this.studentRepository.add(student);
    }

//    @Override
//    public void addOrder(Order order) {
//        this.studentRepository.add(order);
//    }

    @Override
    public void deleteS(Long id) {
        this.studentRepository.deleteStudent(id);
    }

    @Override
    public Page<Student> getStudents(int page) {
        return this.studentLimitRepository.findAll(new PageRequest(page,2));
    }
}
