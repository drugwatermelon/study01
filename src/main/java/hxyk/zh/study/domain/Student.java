package hxyk.zh.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-2-22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
}
