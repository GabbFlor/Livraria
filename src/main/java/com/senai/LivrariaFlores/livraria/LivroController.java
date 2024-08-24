package com.senai.LivrariaFlores.livraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PutMapping("/{id}")
    public Livro atualizaLivro(@PathVariable(value = "id") Long id,
                               @RequestBody Livro livroDetails) {
        Livro resultado = service.updateLivro(id, livroDetails);
        return resultado;
    }

    // recupera um livro pelo id
    @GetMapping("/{id}")
    public Livro getLivro(@PathVariable Long id) {
        Livro resultado = service.getLivroById(id);
        return resultado;
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteLivro(@PathVariable(value = "id") Long id) {
        service.deleteLivro(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("status", Boolean.TRUE);
        return response;
    }
}
