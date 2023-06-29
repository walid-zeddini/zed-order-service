package com.zeddini.api.ms.openfeign.client;

 
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zeddini.api.ms.domain.Produit;

@Component
public class StockSericeFallback implements  StockSericeClient{

   @Override
    public Produit getProduitById(Long produitId) {
//        return null;
        return null;

    }
   
   @Override
   public List<Produit> geProduits(){
       return Collections.emptyList();
   }
}