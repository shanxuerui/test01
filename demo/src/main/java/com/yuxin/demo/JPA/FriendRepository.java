package com.yuxin.demo.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;


/**
 * @author:
 * @date 2020/10/29 14:31
 */
public interface FriendRepository extends JpaRepository<Friend, Integer> {
    //    @Query(value = "update tb_friend set name =?1 where id =?2", nativeQuery = true)
    @Query(value = "update tb_friend set name =:name where id =:id", nativeQuery = true)
    @Modifying
    void updateName(String name,Integer id);


    @Query(value = "update tb_friend set name =:#{#friend.name} where id =:#{#friend.id}", nativeQuery = true)
    @Modifying
    void updateName(Friend friend);

    @Query(value = "select f.name as fname,s.name as sname,s.hobby as hobby from tb_friend f join tb_student s where f.student_id = s.id and f.id = ?1", nativeQuery = true)
    Map<String, String> findFriendAndStudent(Integer id);

    @Query(value = "delete from tb_friend where name = :name", nativeQuery = true)
    @Modifying
    void deleteByName(String name);


    //    @Query(value = "insert into tb_friend(id,name,student_id,hobby) values(?1,?2,?3,?4) ", nativeQuery = true)
    @Query(value = "insert into tb_friend(id,name,student_id,hobby) values(:id,:name,:student_id,:hobby) ", nativeQuery = true)
    @Modifying
    void insert(Integer id,String name,Integer student_id,String hobby);


    @Query(value = "insert into tb_friend(id,name,student_id,hobby) values(:#{#friend.id},:#{#friend.name},:#{#friend.studentId},:#{#friend.hobby}) ", nativeQuery = true)
    @Modifying
    void insert(Friend friend);

}