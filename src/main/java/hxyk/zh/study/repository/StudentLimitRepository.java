package hxyk.zh.study.repository;

import hxyk.zh.study.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017-2-25.
 */
public interface StudentLimitRepository extends CrudRepository<Student, Long>{
    Page<Student> findAll(Pageable pageable);
}
