package com.yuxin.demo.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @author:
 * @date 2020/10/28 18:53
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);
    List<Student> findByNameIn(List<String> name);
    List<Student> findFirst3ByHobbyAndNameInAndAgeInAndIdBetweenOrderByAgeDescIdDesc(String hobby,List<String> names,List<Integer> age,Integer id1,Integer id2);
    @Query(value = "select * from tb_student where name like concat('%',?1,'%') ", nativeQuery = true)
    List<Student> findUserName(String name);

//    @Query(value = "select * from tb_student " +
//            "where if(:#{#student.name} is not null,name like concat('%',:#{#student.name},'%'),1=1) " +
//            "and if(:#{#student.age} is not null, age =:#{#student.age},1=1) " +
//            "and if(:#{#student.hobby} is not null, hobby =:#{#student.hobby},1=1) ", nativeQuery = true)
//    List<Student> findStudent(Student student);

    @Query(value = "select * from tb_student " +
            "where if(:#{#student.name} is not null,name like concat('%',:#{#student.name},'%'),1=1) " +
            "and if(:#{#student.age} is not null, age =:#{#student.age},1=1) " +
            "and if(:#{#student.hobby} is not null, hobby =:#{#student.hobby},1=1) ", nativeQuery = true)
    List<Student> findStudent(Student student);
}
