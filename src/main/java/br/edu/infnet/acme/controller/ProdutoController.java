package br.edu.infnet.acme.controller;

import br.edu.infnet.acme.model.Produto;
import br.edu.infnet.acme.service.ProdutoService;
import br.edu.infnet.acme.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    // LISTAR TODOS OS PRODUTOS
    @GetMapping
    public ResponseEntity listar() {
        // consumir a lista da base
        var produtos = produtoService.listar();
        if (produtos.isEmpty())
            return ResponseEntity.ok().body("Lista vazia.");
        return ResponseEntity.ok().body(produtos);
    }


    // LISTA PRODUTO POR ID
    @GetMapping("/{id}")
    public ResponseEntity exibir(@PathVariable("id") long id) {
        var produto = produtoService.exibir(id);
        return ResponseEntity.ok().body(produto);
    }

    // CADASTRAR PRODUTO
    /*@PostMapping
    public ResponseEntity inserir(@RequestBody Produto produto) {
        if (produto.getNome() == null || produto.getMarca() == null)
            return ResponseEntity.status(400).body("Dados incorretos.");
        var lastIndex = 0L;
        if (!produto.isEmpty())
            lastIndex = produto.get(produto.size() - 1).getId();
        produto.setId(lastIndex + 1);
        if (produto.add(produto))
            return ResponseEntity.status(201).body(produto);
        return ResponseEntity.status(500).body("Erro interno.");
    }*/

    //ATUALIZA UM PRODUTO POR ID
    /*@PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                var nome = produto.getNome();
                if (nome != null)
                    p.setNome(nome);
                var marca = produto.getMarca();
                if (marca != null)
                    p.setMarca(marca);
                return ResponseEntity.ok().body(p);
            }
        }
        return ResponseEntity.status(500).body("Erro interno.");
    }*/

    // ALTERA UM PRODUTO POR ID
    /*@PatchMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Long id, @RequestBody Produto produto) {

        for (Produto p : produtos) {
            if (p.getId() == id) {
                var nome = produto.getNome();
                p.setNome(nome);

                var marca = produto.getMarca();
                p.setMarca(marca);
                return ResponseEntity.ok().body(p);
            }
        }
        return ResponseEntity.status(500).body("Erro interno.");
    }*/

    // REMOVE UM PRODUTO POR ID
    @DeleteMapping("/{idProduto}")
    public ResponseEntity remover(@PathVariable("idProduto") long idProduto) {

        boolean resultado = produtoService.excluir(idProduto);
        if (resultado) {
            return ResponseEntity.ok().body("Usuário excluido.");
        } else {
            return ResponseEntity.internalServerError().body("Erro ao excluir, confira as informações e tente novamente.");
        }

    }

}