package br.com.yescience.yescienceapi.requests;

import lombok.Data;

@Data
public class SalvarPostsRequest {
    private String titulo;
    private String conteudo;
    private String imagem;
    private Integer authorId;
}
