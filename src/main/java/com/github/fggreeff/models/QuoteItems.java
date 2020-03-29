package com.github.fggreeff.models;

import javax.persistence.*;

/**
 * Represents a quote item record in mysql
 */

@Entity
@Table(name = "quote_items", schema = "dev")
public class QuoteItems {

    @Id
    @Column(name = "all_quote_items_uid")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "product_uid")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_cost")
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "quote_uid")
    private Quote quote;

    public void setId(long id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setQuoteUID(Quote quote) {
        this.quote = quote;
    }
}
