package br.edu.infnet.acme.repository;

import br.edu.infnet.acme.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends JpaRepository<Produto, Long> {}