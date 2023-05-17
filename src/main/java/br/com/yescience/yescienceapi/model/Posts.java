package br.com.yescience.yescienceapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String conteudo;
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "author")
    private Author author;
}
