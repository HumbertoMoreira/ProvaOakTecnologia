package com.example.Oak.Tecnologia.ProvaOakTecnologia.service;

import com.example.Oak.Tecnologia.ProvaOakTecnologia.domain.Disponibilidade;
import com.example.Oak.Tecnologia.ProvaOakTecnologia.domain.Produto;
import com.example.Oak.Tecnologia.ProvaOakTecnologia.dto.ProdutoDto;
import com.example.Oak.Tecnologia.ProvaOakTecnologia.repository.ProdutoRepository;
import com.example.Oak.Tecnologia.ProvaOakTecnologia.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto insert(Produto obj){
        obj.setId(null);
        obj.setDisponibilidade(Disponibilidade.SIM);
        obj = produtoRepository.save(obj);
        return obj;
    }

    public Produto find(Integer id){
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! Id: " + id + Produto.class.getName()));

    }

    public List<Produto> findAll(){
        List<Produto> list = produtoRepository.findAll();
        return list;
    }

    public Produto update(Produto obj){
        Produto produtoAtt = find(obj.getId());
        updateData(produtoAtt, obj);
        return produtoRepository.save(produtoAtt);
    }

    private void updateData(Produto produtoNovo, Produto produtoAntigo){
        produtoNovo.setNomeProduto(produtoAntigo.getNomeProduto());
        produtoNovo.setDescricaoProduto(produtoAntigo.getDescricaoProduto());
        produtoNovo.setValorProduto(produtoAntigo.getValorProduto());
        produtoNovo.setDisponibilidade(produtoAntigo.getDisponibilidade());

    }

    public Produto fromDto(ProdutoDto objDto){
        return new Produto(objDto.getId(), objDto.getNomeProduto(), objDto.getDescricaoProduto(),
                objDto.getValorProduto(), objDto.getDisponibilidade());
    }

    public void delete(Integer id){
        produtoRepository.deleteById(id);
    }

    public List<Produto> findAllByOrdem(){
        List<Produto> listOrdemMenorMaior = produtoRepository.findAllByOrdem();
        return listOrdemMenorMaior;
    }


}
