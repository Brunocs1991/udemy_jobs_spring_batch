package br.com.brunocs.springbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class imprimeOlaTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        System.out.println("Olá mundo!");
        return RepeatStatus.FINISHED;
    }
}
