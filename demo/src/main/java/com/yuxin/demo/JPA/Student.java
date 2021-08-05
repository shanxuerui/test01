package com.yuxin.demo.JPA;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * @className Student
 * @author:
 * @date 2020/10/28 18:48
 */
@Table(name = "tb_student")
@Entity
@DynamicInsert
@DynamicUpdate
//@Data
public class
Student {

    @Id
    @Column(name = "id", columnDefinition = "int auto_increment comment '主键'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar(32) comment '姓名'")
    private String name;

    @Column(name = "age", columnDefinition = "int(11) comment '年龄'")
    private Integer age;

    @Column(name = "sex", columnDefinition = "varchar(32) comment '性别'")
    private String sex;

    @Column(name = "hobby", columnDefinition = "varchar(32) comment '爱好'")
    private String hobby;



//    @OneToMany(mappedBy = "studentId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    @OneToMany()
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private List<Friend> friends;

    public Student(Integer id, String name, Integer age, String sex, String hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
    }

    public Student() {
    }
}
