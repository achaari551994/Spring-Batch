package com.example.spring_batch.config;

import com.example.spring_batch.student.Student;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student,Student> {


    @Override
    public Student process(Student student) throws Exception {
        //all business logic
        student.setId(null);
        return student;
    }
}
