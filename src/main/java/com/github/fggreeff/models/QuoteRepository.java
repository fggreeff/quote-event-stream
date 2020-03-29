package com.github.fggreeff.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring JPA Repository for interacting with the quote sql table
 */
public interface QuoteRepository extends CrudRepository<Quote, Long> {
}
