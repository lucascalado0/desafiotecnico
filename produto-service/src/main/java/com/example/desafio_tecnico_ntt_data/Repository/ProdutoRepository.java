package com.example.desafio_tecnico_ntt_data.Repository;

import com.example.desafio_tecnico_ntt_data.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
