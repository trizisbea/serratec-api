package org.serratec.java2backend.exercicio02.repository;
//faz a consulta ao BD
//uma interface que extends outra interface

import org.serratec.java2backend.exercicio02.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
