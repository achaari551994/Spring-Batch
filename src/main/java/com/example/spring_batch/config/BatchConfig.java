package com.example.spring_batch.config;

import com.example.spring_batch.student.Student;
import com.example.spring_batch.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class BatchConfig {

    private final StudentRepository studentRepo;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final StudentItemReader studentItemReader;
    private final StudentItemProcessor studentItemProcessor;
    private final StudentItemWriter studentItemWriter;


//    @Bean
//    public RepositoryItemWriter<Student> write(){
//        RepositoryItemWriter<Student> writer= new RepositoryItemWriter<>();
//        writer.setRepository(studentRepo);
//        writer.setMethodName("save");
//        return writer;
//    }

    @Bean
    public Step myStep() throws Exception {
        return new StepBuilder("myStep",jobRepository)
                .<Student,Student>chunk(10,platformTransactionManager)
                .reader(studentItemReader)
                .processor(studentItemProcessor)
                .writer(studentItemWriter)
                .build();
    }

    @Bean
    public Job myJob() throws Exception {
        return new JobBuilder("myJob",jobRepository)
                .start(myStep())
                .build();
    }

//    @Bean
//    public TaskExecutor taskExecutor(){
//        SimpleAsyncTaskExecutor asyncTaskExecutor=new SimpleAsyncTaskExecutor();
//        asyncTaskExecutor.setConcurrencyLimit(10);
//        return asyncTaskExecutor;
//    }



}
