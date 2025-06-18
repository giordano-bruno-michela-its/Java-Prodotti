package com.example.prodotti.prodotti.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.prodotti.prodotti.entities.Prodotto;

public interface ProdottoRepo extends JpaRepository<Prodotto, Integer> {
    
    List<Prodotto> findByCategoria(String categoria);

}
