package br.edu.infnet.acme.service;

import br.edu.infnet.acme.model.Cotacao;
import br.edu.infnet.acme.model.Produto;
import br.edu.infnet.acme.repository.CotacaoRepository;
import br.edu.infnet.acme.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CotacaoRepository cotacaoRepository;

    // Listar produtos
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    // Adicionar produto
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // exibir produto por id
    public Produto exibir(Long id) {
        return produtoRepository.findById(id).get();
    }

    // atualizar produto
    public Produto atualizar(Produto produto) {
        return this.salvar(produto);
    }

    // excluir
    public boolean excluir(Long id) {
        produtoRepository.deleteById(id);
        return false;
    }

}
