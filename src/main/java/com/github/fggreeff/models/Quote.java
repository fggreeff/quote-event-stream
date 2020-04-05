package com.github.fggreeff.models;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a quote record in mysql
 */
@Setter
@Entity
@Table(name = "quotes", schema = "quote_schema")
public class Quote {

    @Id
    @Column(name = "quote_uid")
    private String quoteId; //  PK

    @Column(name = "reference")
    private String quoteReference;
    @Column(name = "timestamp")
    private String quoteTimestamp;
    @Column(name = "is_first_quote")
    private Boolean quoteIsFirstQuote;

    @Column(name = "event_type")
    private String eventType;

    // setters and getters

}