package com.example.Oak.Tecnologia.ProvaOakTecnologia.repository;

import com.example.Oak.Tecnologia.ProvaOakTecnologia.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Query("SELECT p FROM Produto p ORDER BY p.valorProduto ")
    List<Produto> findAllByOrdem();
}
