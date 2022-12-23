package com.spring.datajpa.springdatajpatutorial.entity.repository;

import com.spring.datajpa.springdatajpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String fname);

    public List<Student> findByFirstNameContaining(String name);

//    public List<Student> findByLastNameNotNull(String name);

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String fname, String lname);

    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailId(String emailId);

    @Query("select s.firstName from Student s where s.emailId= ?1")
    String getStudentFirstNameByEmailId(String emailId);

    @Query(
            value="select s.first_name , s.last_name , s.email_address from tbl_student s where s.guardian_name=?1",
            nativeQuery = true
    )
    List<String> getFirstLastEmailByGuardianNameNative(String guardianName);

    @Query(
            value = "select s.guardian_name from tbl_student s where s.first_name=:firstName and s.last_name=:lastName",
            nativeQuery = true
    )
    String getGuardianNameByFirstAndLastNameNativeParam(@Param("firstName")String firstName,
                                                        @Param("lastName")String lastName);
    @Modifying
    @Transactional
    @Query(
            value="update tbl_student s set s.first_name=:firstName where s.email_address=:emailId",
            nativeQuery = true
    )
    int updateStudentByEmailId(@Param("firstName")String firstName,
                                @Param("emailId")String emailId);


}
