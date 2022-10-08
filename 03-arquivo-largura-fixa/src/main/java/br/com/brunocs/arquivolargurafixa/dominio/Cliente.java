package br.com.brunocs.arquivolargurafixa.dominio;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Cliente {
    private String nome;
    private String sobrenome;
    private String idade;
    private String email;
}
