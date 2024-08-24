package com.senai.LivrariaFlores.livraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
// Permitindo qualquer site de usar a API (se não usar, da CORs error no console do site)
@CrossOrigin(origins = "*", maxAge = 3600)
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

    @GetMapping
    public List<Livro> listar() {
        return service.getAllLivros();
    }

}
