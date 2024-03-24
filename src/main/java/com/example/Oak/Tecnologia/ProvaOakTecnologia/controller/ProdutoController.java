package com.example.Oak.Tecnologia.ProvaOakTecnologia.controller;

import com.example.Oak.Tecnologia.ProvaOakTecnologia.domain.Produto;
import com.example.Oak.Tecnologia.ProvaOakTecnologia.dto.ProdutoDto;
import com.example.Oak.Tecnologia.ProvaOakTecnologia.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> insert(@Validated @RequestBody Produto produto){
        Produto obj = produtoService.insert(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> find(@PathVariable Integer id){
        Produto produto = produtoService.find(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
       List<Produto> list = produtoService.findAll();
       return ResponseEntity.ok().body(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@RequestBody ProdutoDto dto, @PathVariable Integer id){
        Produto obj = produtoService.fromDto(dto);
        obj.setId(id);
        Produto produto = produtoService.update(obj);
        return ResponseEntity.ok(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ordem")
    public ResponseEntity<List<Produto>> findAllByOrdem(){
        List<Produto> list = produtoService.findAllByOrdem();
        return ResponseEntity.ok().body(list);
    }

}
