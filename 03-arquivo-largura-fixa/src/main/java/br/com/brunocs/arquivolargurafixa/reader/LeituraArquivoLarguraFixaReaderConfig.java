package br.com.brunocs.arquivolargurafixa.reader;

import br.com.brunocs.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoLarguraFixaReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Cliente> leituraArquivoLarguraFixaReader(@Value("${app.arquivo}")Resource resource) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("leituraArquivoLarguraFixaReader")
                .resource(resource)
                .fixedLength()
                .columns(new Range[]{new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43)})
                .names(new String[]{"nome", "sobrenome", "idade", "email"})
                .targetType(Cliente.class)
                .build();
    }
}
