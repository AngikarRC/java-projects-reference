package com.spring.datajpa.springdatajpatutorial.entity.repository;

import com.spring.datajpa.springdatajpatutorial.entity.Guardian;
import com.spring.datajpa.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

    Student student = Student.builder()
            .emailId("arc1997@gmail.com")
            .firstName("Angikar")
            .lastName("Roy Chowdhury")
            //.GuardianName("Chinmoy")
            //.GuardianEmail("chinmui66@gmail.com")
            //.GuardianMobile("9938829092")
            .build();

    studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("IronMan31@gmail.com")
                .name("Iron Man")
                .mobile("00212311232")
                .build();

        Student student = Student.builder()
                .emailId("Hello2@gmial.com")
                .firstName("Greetings")
                .lastName("Tech")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){

        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void getStudentsByFirstName(){
        List<Student> students= studentRepository.findByFirstName("Ant");
        System.out.println("students:"+students);
    }

    @Test
    public void getStudentsByFirstNameContaining(){
        List<Student> students= studentRepository.findByFirstNameContaining("An");
        System.out.println("students:"+students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Iron Man");
        System.out.println("Students:"+students);
    }

//    @Test
//    public void printStudentBasedOnLastNameNotNull(){
//        List<Student> students = studentRepository.findByLastNameNotNull("Man");
//        System.out.println("Students Last Name"+students);
//    }

    @Test
    public void printStudentByEmailId(){
        Student student = studentRepository.getStudentByEmailId("arc1997@gmail.com");
        System.out.println("Student= "+student);
    }
    @Test
    public void printStudentFirstNameByEmailAddress(){
        String fname = studentRepository.getStudentFirstNameByEmailId("arc1997@gmail.com");
        System.out.println("Student firstname is ="+fname);
    }
    @Test
    public void printFnameLnameEmailByGuardianName(){
        List<String> result = studentRepository.getFirstLastEmailByGuardianNameNative("Iron Man");
        System.out.println("Result :"+result);
        if(result.indexOf("Ant")==0)
        {
            System.out.println("Test is passed");
        }
    }
    @Test
    public void getGuardianNameByFullName(){
        System.out.println(studentRepository.getGuardianNameByFirstAndLastNameNativeParam("Angikar","Roy Chowdhury"));
    }
    @Test
    public void setFirstNameBasedOnEmailAddress(){
        studentRepository.updateStudentByEmailId("Ram","spyder21@gmial.com");
    }

}