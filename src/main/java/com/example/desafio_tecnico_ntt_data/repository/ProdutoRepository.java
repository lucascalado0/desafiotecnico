package com.example.desafio_tecnico_ntt_data.repository;

import com.example.desafio_tecnico_ntt_data.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
