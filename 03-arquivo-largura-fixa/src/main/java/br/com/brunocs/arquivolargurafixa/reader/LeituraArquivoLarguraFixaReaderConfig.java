package br.com.brunocs.arquivolargurafixa.reader;

import br.com.brunocs.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaReaderConfig {

    @Bean
    public FlatFileItemReader<Cliente> leituraArquivoLarguraFixaReader(){
        //TODO implementar leitor de arquivo de largura fixa;
        return null;
    }
}
