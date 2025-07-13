package com.example.desafio_tecnico_ntt_data.Controller;

import com.example.desafio_tecnico_ntt_data.DTO.ProdutoDTO;
import com.example.desafio_tecnico_ntt_data.Entity.Produto;
import com.example.desafio_tecnico_ntt_data.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.cadastrarProduto(produtoDTO);

        return ResponseEntity.ok(new ProdutoDTO(produto));
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        List<ProdutoDTO> produtos = produtoService.listarProdutos();

        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(produtos);
    }

    @GetMapping(value = "/consultar/{id}")
    public ResponseEntity<Optional<ProdutoDTO>> consultarProduto(@PathVariable Long id) {
        Optional<ProdutoDTO> produtoDTO = produtoService.consultarProduto(id);

        if (produtoDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtoDTO);
    }


}
