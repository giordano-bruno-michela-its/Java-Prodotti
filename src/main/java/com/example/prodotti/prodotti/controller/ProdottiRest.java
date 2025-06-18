package com.example.prodotti.prodotti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.prodotti.prodotti.service.ProdottoService;
import com.example.prodotti.prodotti.entities.Prodotto;
import java.util.List;

@RestController
@RequestMapping("api")
public class ProdottiRest {

    private final ProdottoService service;

    public ProdottiRest(ProdottoService service) {
        this.service = service;
    }

    @GetMapping("prodotti")
    public List<Prodotto> getProdotti() {
        return service.getProdotti();
    }

    @GetMapping("prodotti/cat/{categoria}")
    public List<Prodotto> getProdotti(@PathVariable String categoria) {
        return service.getProdottiByCategoria(categoria);
    }

    @GetMapping("prodotti/{id}")
    public ResponseEntity<Prodotto> getProdottoById(@PathVariable int id) {
        try {
            Prodotto prodotto = service.getProdottoById(id);
            return ResponseEntity.ok(prodotto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("prodotti")
    @ResponseStatus(HttpStatus.CREATED)
    public Prodotto addProdotto(@RequestBody Prodotto prodotto) {
        return service.addProdotto(prodotto);
    }

    @PutMapping("prodotti")
    public Prodotto updateProdotto(@RequestBody Prodotto prodotto) {
        return service.updaProdotto(prodotto);
    }

    @DeleteMapping("prodotti/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProdotto(@PathVariable int id) {
        service.deleteProdotto(id);
    }
}
