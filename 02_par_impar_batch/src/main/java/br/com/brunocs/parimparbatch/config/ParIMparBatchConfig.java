package br.com.brunocs.parimparbatch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class ParIMparBatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job imprimeParImparJob(){
        return jobBuilderFactory
                .get("imprimeParImparJob")
                .start(imprimeParImparStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    private Step imprimeParImparStep() {
        return stepBuilderFactory
                .get("imprimeParImparStep")
                .<Integer, String> chunk(500)
                .reader(contaAteDezReader())
                .processor(parOuImparProcessor())
                .writer(imprimeWriter())
                .build();
    }

    private IteratorItemReader<Integer> contaAteDezReader() {
        List<Integer> numerosUmAteDez = new ArrayList<>();
        for (int i = 1; i< 2000; i++){
            numerosUmAteDez.add(i);
        }
        return new IteratorItemReader<Integer>(numerosUmAteDez.iterator());
    }


    private FunctionItemProcessor<Integer, String> parOuImparProcessor() {
        return new FunctionItemProcessor<>(item -> item %2 == 0? String.format("Item %s é Par", item): String.format("Item %s é Impar", item));
    }
    private ItemWriter<String> imprimeWriter() {
        return itens -> itens.forEach(System.out::println);
    }

}
