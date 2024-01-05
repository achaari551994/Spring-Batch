package com.example.spring_batch.config;

import com.example.spring_batch.student.Student;
import com.example.spring_batch.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class StudentItemWriter implements ItemWriter<Student> {

    private final StudentRepository studentRepo;

    @Override
    public void write(Chunk<? extends Student> chunk) throws Exception {
        log.info("chunk size "+chunk.size());
        log.info("chunk size "+chunk);
        studentRepo.saveAll(chunk);
    }
}
