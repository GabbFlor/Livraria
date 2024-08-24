package com.senai.LivrariaFlores.livraria;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LivroService {
//    Coloca o caminho do arquivo na variável
    private static final String FILE_PATH = "livros.json";
    private List<Livro> livros = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    // salva o livro
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

    // coleta todos os livros
    public LivroService() {
        carregarLivros();
    }

    public List<Livro> getAllLivros() {
        return livros;
    }

    private void carregarLivros() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                // Lê o arquivo .json e converte para um array de livros
                Livro[] livrosArray = mapper.readValue(file, Livro[].class);
                for (Livro livro : livrosArray) {
                    // Lê a lista de livros que veio do .json e adiciona na lista de livros lá em cima
                    livros.add(livro);
                    counter.set(Math.max(counter.get(), livro.getId()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // update livro
    public Livro updateLivro(Long id, Livro livroDetails) {
        // chama a função de coletar as infos do livro e armazena elas
        Livro livro = getLivroById(id);
        if (livro == null) {
            throw new RuntimeException("Livro não encontrado com o id : " + id);
        }

        livro.setFotoCapa(livroDetails.getFotoCapa());
        livro.setNome(livroDetails.getNome());
        livro.setAutor(livroDetails.getAutor());
        livro.setAno(livroDetails.getAno());
        livro.setExemplares(livroDetails.getExemplares());

        salvarLivros();
        return livro;
    }

    // logica para capturar as informações do livro pelo id dele
    public Livro getLivroById(Long id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    // pega o livro específico pelo id
    public void deleteLivro(Long id) {
        Livro livro = getLivroById(id);
        if (livro == null) {
            throw new RuntimeException("Livro não encontrado com o id : " + id);
        }
        livros.remove(livro);
        salvarLivros();
    }
}
