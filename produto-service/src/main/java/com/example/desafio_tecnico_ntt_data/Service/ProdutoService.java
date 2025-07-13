package com.example.desafio_tecnico_ntt_data.Service;


import com.example.desafio_tecnico_ntt_data.DTO.ProdutoDTO;
import com.example.desafio_tecnico_ntt_data.Entity.Produto;
import com.example.desafio_tecnico_ntt_data.Exception.RecursoNaoEncontradoException;
import com.example.desafio_tecnico_ntt_data.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(ProdutoDTO produtoDTO){
        Produto produto = produtoDTO.toEntity();

        return produtoRepository.save(produto);
    }

    public List<ProdutoDTO> listarProdutos(){
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<ProdutoDTO> consultarProduto(Long id){
        return Optional.ofNullable(produtoRepository.findById(id)
                .map(ProdutoDTO::new)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com ID: " + id)));
    }
}
