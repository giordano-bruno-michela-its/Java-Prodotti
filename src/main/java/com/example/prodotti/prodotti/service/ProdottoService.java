package com.example.prodotti.prodotti.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.prodotti.prodotti.entities.Prodotto;

public interface ProdottoService {
    
    List<Prodotto> getProdotti();
    List<Prodotto> getProdottiByCategoria(String categoria);
    Prodotto getProdottoById(int id);
    Prodotto addProdotto(Prodotto p);
    Prodotto updaProdotto(Prodotto p);
    void deleteProdotto(int id);
}
