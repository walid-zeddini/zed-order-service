package com.zeddini.api.ms.repository;
/*
 * Copyright 2021 Zeddini, as indicated by the @author tags.
 *
 * Licensed under the zeddini License; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.zeddini.com/licenses/LICENSE-2.0
 *
 * @author  Zeddini Walid
 * @version 1.0.0
 * @since   2021-11-05 
 */

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zeddini.api.ms.domain.Client;
  
/**
 * Spring Data  repository for the Client entity.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	/**
	 * 
	 * NOTA:  
		* Remember that Spring Data systematically manages classic CRUDs without having
		* to implement them such as save, update, delete find All and find by ID.
		* However, we can overload them as we wish (if needed)
		* Query, Query Native
	 */
		
/**
 * Queries (Methods) relating to the main Business Rules (search)
 */

public Optional<Client> findFirstByOrderByNomAsc();

public  Client findByGsmAndEmail(String gsm, String email);

public  Client findByGsmOrEmail(String gsm, String email);


public Page<Client> findByNom(String nom, Pageable pageable);
public Page<Client> findByPrenom(String prenom, Pageable pageable);
public Page<Client> findByAdresse( String adresse, Pageable pageable);
public Page<Client> findByVille( String ville, Pageable pageable);
public Page<Client> findByCodePostal( String codePostal, Pageable pageable);

 
/**
 * Finders
 */
public List<Client> findByDateNaissanceBetween(LocalDate dateDebut, LocalDate dateFin);

public List<Client>  findByNomLike(String nom);
public List<Client>  findByPrenomLike(String prenom);

public List<Client> findByAdresseLike( String villeAdr);


public List<Client> findByVilleLike( String villeAdr);
public List<Client> findByCodePostalLike( String cpAdr);
public List<Client> findByDateNaissance(LocalDate dateNaissance);

public List<Client> findByGsmLike( String gsm);
public List<Client> findByEmailLike( String email);


/**
 * Just an example in case we want to appeal
  * to the query (which is not recommended for Spring Data performace)
 */

@Query("SELECT c FROM Client c WHERE c.ville = :town")
public List<Client> findClientByVille(@Param("town") String villeClt);

 





}