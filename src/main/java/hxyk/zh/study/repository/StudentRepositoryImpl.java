package hxyk.zh.study.repository;

import hxyk.zh.study.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Administrator on 2017-2-23.
 */
@Repository
@Slf4j
public class StudentRepositoryImpl implements StudentRepository{

    @Autowired
    private SessionFactory _sessionFactory;
    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    @Override
    public Student findStudent(Long id) {
        return (Student)getSession().createQuery("from Student as s where s.id = ?")
                .setParameter(0,id).uniqueResult();
    }

    @Override
    public List<Student> findAll() {
        return getSession().createQuery("from Student").list();
    }

    @Override
    public void modify(Student student) {
//        int i = getSession().createQuery("update Student s set s.name = :names ,s.age=:age where s.id = :id")
//                .setString("names", student.getName()).setInteger("age", student.getAge()).setLong("id", student.getId())
//                .executeUpdate();
        getSession().saveOrUpdate(student);
    }

    @Override
    public void add(Student student) {
        getSession().saveOrUpdate(student);
    }

//    @Override
//    public void add(Order order) {
//        getSession().saveOrUpdate(order);
//    }

    @Override
    public void deleteStudent(Long id) {
        getSession().createQuery("delete Student as s where s.id= :id").setLong("id",id).executeUpdate();
    }
}
