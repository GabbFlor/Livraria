package com.senai.LivrariaFlores.livraria;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LivroService {
//    Coloca o caminho do arquivo na variável
    private static final String FILE_PATH = "livros.json";
    private List<Livro> livros = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public Livro createLivro(Livro livro) {
        livro.setId(counter.incrementAndGet());
        livros.add(livro);
        salvarLivros();
        return livro;
    }

    private void salvarLivros() {
        ObjectMapper mapper = new ObjectMapper();
        try {
//            salva o livro no local indicado pela "FILE_PATH"
            mapper.writeValue(new File(FILE_PATH), livros);
        } catch (IOException e) {
//            trata as excessoes
            e.printStackTrace();
        }
    }
}
