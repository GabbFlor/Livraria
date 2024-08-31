package com.senai.LivrariaFlores.livraria.adapters.out.persistense;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// anotações para funcionar com banco de dados
@Data
@Entity
@Table(name = "livros")
public class LivroEntity {
    // seta o id como chave primária da tabela
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // aumenta o tamanho das colunas para caber a imagem em BASE64 (pq o código é mt grande)
    @Column(length = Integer.MAX_VALUE)
    private String fotoCapa;
    private String nome;
    private String autor;
    private Integer ano;
    private Integer exemplares;
}
