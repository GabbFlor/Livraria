package com.senai.LivrariaFlores.livraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

//    cria a referência para ser possível de chamar o service do livro
//    @Autowired é injeção de dependência
    @Autowired
    private LivroService service;

    @PostMapping()
    public Livro criarlivro(@RequestBody Livro livro) {
        service.createLivro(livro);
//        System.out.println(livro.getNome());
        return null;
    }

}
