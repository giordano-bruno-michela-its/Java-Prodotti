package com.example.prodotti.prodotti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prodotti.prodotti.entities.Prodotto;
import com.example.prodotti.prodotti.repos.ProdottoRepo;

@Service
public class ProdottoServiceImpl implements ProdottoService {

    private final ProdottoRepo repo;

    @Autowired
    public ProdottoServiceImpl(ProdottoRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Prodotto> getProdotti() {
        return repo.findAll();
    }

    @Override
    public List<Prodotto> getProdottiByCategoria(String categoria) {
        return repo.findByCategoria(categoria);
    }

    @Override
    public Prodotto getProdottoById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con id: " + id));
    }

    @Override
    public Prodotto addProdotto(Prodotto p) {
        return repo.save(p);
    }

    @Override
    public Prodotto updaProdotto(Prodotto p) {
        if (repo.existsById(p.getId())) {
            return repo.save(p);
        } else {
            throw new RuntimeException("Prodotto non trovato con id: " + p.getId());
        }
    }

    @Override
    public void deleteProdotto(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Prodotto non trovato con id: " + id);
        }
    }

}
