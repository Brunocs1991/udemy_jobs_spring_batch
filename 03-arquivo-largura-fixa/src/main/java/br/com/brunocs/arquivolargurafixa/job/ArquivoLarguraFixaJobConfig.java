package br.com.brunocs.arquivolargurafixa.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class ArquivoLarguraFixaJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job arquivoLarguraFicaJob(Step leituraArquivoLarguraFixaStep){
        return jobBuilderFactory
                .get("arquivoLarguraFicaJob")
                .start(leituraArquivoLarguraFixaStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
