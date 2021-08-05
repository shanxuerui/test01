package com.yuxin.demo.JPA;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 * @className Student
 * @author:
 * @date 2020/10/28 18:48
 */
@Table(name = "tb_friend")
@Entity
@DynamicInsert
@DynamicUpdate
//@Data
public class Friend {
    @Id
    @Column(name = "id", columnDefinition = "int auto_increment comment '主键'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",columnDefinition = "varchar(32) comment '姓名'")
    private String name;

    @Column(name = "hobby",columnDefinition = "varchar(32) comment '爱好'")
    private String hobby;

    @Column(name = "studentId", columnDefinition = "int(11) comment '关联的学生id'")
    private Integer studentId;
}

