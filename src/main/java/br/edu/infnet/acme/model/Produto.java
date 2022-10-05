package br.edu.infnet.acme.model;

import javax.persistence.*;

@Entity(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String marca;

    private String valor;
    public Produto(){}
    public Produto(long id, String nome, String marca) {
        this.setId(id);
        this.nome = nome;
        this.marca = marca;
    }
    public Produto(String nome, String marca){
        this.setNome(nome);
        this.setMarca(marca);
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Produto [id=" + id + ", marca=" + marca + ", nome=" + nome + "]";
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
