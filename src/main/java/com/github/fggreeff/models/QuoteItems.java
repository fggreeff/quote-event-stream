package com.github.fggreeff.models;

import javax.persistence.*;

import lombok.Setter;

/**
 * Represents a quote item record in mysql
 */
@Setter
@Entity
@Table(name = "quote_items", schema = "quote_schema")
public class QuoteItems {

    @Id
    @Column(name = "all_quote_items_uid")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long Id;

    @Column(name = "product_id")
    public String productId;
    @Column(name = "product_key")
    public String productKey;
    @Column(name = "product_name")
    public String productName;

    @Column(name = "is_offered")
    public Boolean rateIsOffered;
    @Column(name = "base_premium")
    public Float rateBasePremium;
    @Column(name = "discount")
    public String rateDiscount;
    @Column(name = "total")
    public Float rateTotal;
    @Column(name = "status")
    public String rateStatus;

    @ManyToOne
    @JoinColumn(name = "quote_uid") // FK
    private Quote quote;

}
