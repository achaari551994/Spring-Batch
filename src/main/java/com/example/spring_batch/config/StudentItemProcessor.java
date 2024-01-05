package com.example.spring_batch.config;

import com.example.spring_batch.student.Student;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class StudentItemProcessor implements ItemProcessor<Student,Student> {


    @Override
    public Student process(Student student) throws Exception {
        //all business logic
        return student;
    }

}
