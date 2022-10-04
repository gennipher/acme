package br.edu.infnet.acme.controller;

import br.edu.infnet.acme.model.Cotacao;
import br.edu.infnet.acme.model.Produto;
import br.edu.infnet.acme.repository.CotacaoRepository;
import br.edu.infnet.acme.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    @Autowired
    CotacaoRepository cotacaoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    /*@PostMapping
    public Cotacao save(@ModelAttribute @RequestBody Cotacao cotacao) {
        return cotacaoRepository.salvar(cotacao);
    }*/

    /*@PutMapping
    public Cotacao update(@ModelAttribute @RequestBody Cotacao cotacao) {
        return cotacaoRepository.save(cotacao);
    }*/

    /*@GetMapping
    public List<Cotacao> findAll() {
        return (List<Cotacao>) cotacaoRepository.findAll();
    }*/

    @GetMapping(value = "/{id}")
    public Optional<Produto> findById(@PathVariable Long id) {
        return cotacaoRepository.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        cotacaoRepository.deleteById(id);}

    /*@PostMapping ( value = "/registrar")
    public Produto registrarCotacao(@RequestParam Long id,@ModelAttribute @RequestBody Cotacao cotacao) {
        Produto produto;
        produto = produtoRepository.findById(id).orElse(null);
        if (produto != null) {
            List<Cotacao> cotacoes = new ArrayList<>();
            cotacoes.add(cotacao);
            cotacao.setProdutos(produtoRepository.findAll(produto.getId()));
            produto.setCotacao(cotacoes);
            return produtoRepository.save(produto);
        } else
            return null;
    }*/
}
