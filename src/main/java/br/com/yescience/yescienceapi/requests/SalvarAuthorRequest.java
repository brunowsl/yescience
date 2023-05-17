package br.com.yescience.yescienceapi.requests;

import lombok.Data;

@Data
public class SalvarAuthorRequest {
    private String nome;
    private String email;
    private String qualificacao;
}
