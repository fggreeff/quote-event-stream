package com.github.fggreeff.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring JPA Repository for interacting with the quote sql table
 */
@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
}