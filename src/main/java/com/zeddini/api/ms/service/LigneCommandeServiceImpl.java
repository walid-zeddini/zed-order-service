package com.zeddini.api.ms.service;
import com.zeddini.api.ms.domain.LigneCommande;
import com.zeddini.api.ms.domain.Produit;
import com.zeddini.api.ms.openfeign.client.StockSericeClient;
import com.zeddini.api.ms.repository.LigneCommandeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for implementing methods declared in Interface linked to  {@link LigneCommande}.
 */
@Service
@Transactional
public class LigneCommandeServiceImpl implements ILigneCommandeService {

    private final Logger log = LoggerFactory.getLogger(LigneCommandeServiceImpl.class);

    private final LigneCommandeRepository ligneCommandeRepository;
    
    private final StockSericeClient stockSericeClient;

    public LigneCommandeServiceImpl(LigneCommandeRepository ligneCommandeRepository,
    		StockSericeClient stockSericeClient) {
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.stockSericeClient = stockSericeClient;
    }

     /**
     * Save a ligneCommande.
     *
     * @param ligneCommande the entity to save.
     * @return the persisted entity.
     */
    public LigneCommande save(LigneCommande ligneCommande) {
        log.debug("Request to save LigneCommande : {}", ligneCommande);
        return ligneCommandeRepository.save(ligneCommande);
    }

    /**
     * Get all the ligneCommandes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<LigneCommande> findAll(Pageable pageable) {
        log.debug("Request to get all LigneCommandes");
        return ligneCommandeRepository.findAll(pageable);
    }


    /**
     * Get one ligneCommande by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<LigneCommande> findOne(Long id) {
        log.debug("Request to get LigneCommande : {}", id);
        return ligneCommandeRepository.findById(id);
    }

    /**
     * Delete the ligneCommande by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete LigneCommande : {}", id);
        ligneCommandeRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
	public List<LigneCommande> findAll() {
        return ligneCommandeRepository.findAll();
	}

	@Override
	public List<Produit> getProduits() {
		return stockSericeClient.geProduits();
	}

	@Override
	public Produit getProduitById(Long id) {
		return stockSericeClient.getProduitById(id);
	}
}
