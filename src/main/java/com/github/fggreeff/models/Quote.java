package com.github.fggreeff.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Represents a quote record in mysql
 */

@Entity
@Table(name = "quotes", schema = "dev")
public class Quote {
    //TODO: Consider making the id the UID of the quote
    @Id
    @Column(name = "all_quotes_uid")
    private long id;

    @Column(name = "quote_uid")
    private String quoteId;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "row_create_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public void setQuoteUID(String quoteId) {
        this.quoteId = quoteId;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // setters and getters

}
