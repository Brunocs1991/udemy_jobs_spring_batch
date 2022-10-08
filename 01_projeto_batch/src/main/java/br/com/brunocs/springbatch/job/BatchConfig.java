package br.com.brunocs.springbatch.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job imprimeOlaJob(Step imprimeOlaStep) {
        return jobBuilderFactory
                .get("imprimeOlaJob")
                .start(imprimeOlaStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
