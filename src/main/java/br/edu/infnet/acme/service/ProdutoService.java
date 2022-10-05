package br.edu.infnet.acme.service;

import br.edu.infnet.acme.model.Produto;
import br.edu.infnet.acme.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    // LISTAR PRODUTO
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    // CRIAR PRODUTO
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // EXIBIR PRODUTO
    public Produto exibir(Long id) {
        return produtoRepository.findById(id).get();
    }

    // ATUALIZAR PRODUTO
    public Produto atualizar(Produto produto) {
        return this.salvar(produto);
    }

    // EXCLUIR PRODUTO
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

}