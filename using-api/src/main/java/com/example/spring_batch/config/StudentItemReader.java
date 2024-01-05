package com.example.spring_batch.config;

import com.example.spring_batch.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@JobScope
public class StudentItemReader implements ItemReader<Student>, ItemStream {

    private FlatFileItemReader reader;
    private String fileContent;

    public  StudentItemReader(@Value("#{jobParameters['fileContent']}")
                              String fileContent){
        this.fileContent=fileContent;
        reader = new FlatFileItemReader<Student>();
        reader.setResource(new ByteArrayResource(fileContent.getBytes()));
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());
    }

    @Override
    public void open(ExecutionContext arg0) throws ItemStreamException {
        reader.open(arg0);
    }

    @Override
    public Student read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        return (Student) reader.read();
    }

    private LineMapper<Student> lineMapper(){
        DefaultLineMapper<Student> lineMapper=new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id","firstName","lastName","age");
        BeanWrapperFieldSetMapper<Student> fieldSetMapper=new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Student.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }



}