package br.edu.infnet.acme.controller;

import br.edu.infnet.acme.model.Produto;
import br.edu.infnet.acme.service.CsvService;
import br.edu.infnet.acme.service.ProdutoService;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    CsvService csvService;

    //LISTAR TODOS OS PRODUTOS
    @GetMapping
    public ResponseEntity listar() {
        var produtos = produtoService.listar();
        if (produtos.isEmpty())
            return ResponseEntity.ok().body("Lista vazia.");
        return ResponseEntity.ok().body(produtos);
    }

    // LISTAR PRODUTOS POR ID
    @GetMapping("/{id}")
    public ResponseEntity exibir(@PathVariable long id) {
        try {
            var produto = produtoService.exibir(id);
            return ResponseEntity.ok().body(produto);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Nenhum produto encontrado.");
        }
    }

    // GERAR CSV POR ID DO PRODUTO
    @GetMapping("/gerarCsv/{id}")
    public ResponseEntity gerarCsv(@PathVariable long id) {
        try {
            var produto = produtoService.exibir(id);
            csvService.ProdutoCsv(produto);
            return ResponseEntity.ok().body(produto);

        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("Lista de Produtos Vazia.");
        }
    }

    // CADASTRAR PRODUTO
    @PostMapping
    public ResponseEntity inserir(@RequestBody Produto produto) {
        if (produto.getNome() == null || produto.getMarca() == null || produto.getValor() == null)
            return ResponseEntity.status(400).body("Dados incorretos.");

        produto = produtoService.salvar(produto);
        if (produto.getId() != 0)
            return ResponseEntity.status(201).body(produto);

        return ResponseEntity.status(500).body("Erro interno.");
    }

    // ATUALIZAR PRODUTO POR ID
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        if (produto.getNome() == null || produto.getMarca() == null || produto.getValor() == null)
            return ResponseEntity.status(400).body("Dados incorretos.");
        produto.setId(id);
        produto = produtoService.salvar(produto);
        return ResponseEntity.status(201).body(produto);
    }

    // REMOVER PRODUTO POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id) {
        produtoService.excluir(id);
        return ResponseEntity.ok().body("Produto excluido.");
    }

}