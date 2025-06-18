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
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public List<Prodotto> getProdottiByCategoria(String categoria) {
        // TODO Auto-generated method stub
        return repo.findByCategoria(categoria);
    }

    @Override
    public Prodotto getProdottoById(int id) {
        // TODO Auto-generated method stub
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con id: " + id));
    }

    @Override
    public Prodotto addProdotto(Prodotto p) {
        // TODO Auto-generated method stub
        return repo.save(p);
    }

    @Override
    public Prodotto updaProdotto(Prodotto p) {
        // TODO Auto-generated method stub
        if (repo.existsById(p.getId())) {
            return repo.save(p);
        } else {
            throw new RuntimeException("Prodotto non trovato con id: " + p.getId());
        }
    }

    @Override
    public void deleteProdotto(int id) {
        // TODO Auto-generated method stub
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Prodotto non trovato con id: " + id);
        }
    }

}
