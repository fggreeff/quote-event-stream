package com.github.fggreeff.transformers;

import com.github.fggreeff.domains.QuoteProductsUpdated;
import com.github.fggreeff.domains.QuoteStarted;
import com.github.fggreeff.models.Quote;
import com.github.fggreeff.models.QuoteItems;
import org.apache.log4j.Logger;

public class EventToQuote {
    static Logger logger = Logger.getLogger(EventToQuote.class);

    // TODO: Consider using Java map
    // The data originates from the quote_started event (Class associated: QuoteStarted)
    public Quote quoteStarted(QuoteStarted quoteStarted, String eventType){

        Quote quote = new Quote();
        quote.setQuoteId(quoteStarted.getId());
        quote.setQuoteReference(quoteStarted.getReference());
        quote.setQuoteTimestamp(quoteStarted.getTimestamp());
        quote.setQuoteIsFirstQuote(quoteStarted.getIsFirstQuote());

        quote.setEventType(eventType);

        return new Quote();
    }


    // The data originates from the quote_products_updated event (Class associated: QuoteProductsUpdated, Product, Rate)
    public QuoteItems quoteProductsUpdated(QuoteProductsUpdated quoteProductsUpdated){
        QuoteItems quoteItem = new QuoteItems();

        quoteItem.setProductId(quoteProductsUpdated.getProducts().get(0).getId());
        quoteItem.setProductKey(quoteProductsUpdated.getProducts().get(0).getKey());
        quoteItem.setProductName(quoteProductsUpdated.getProducts().get(0).getName());

        quoteItem.setRateIsOffered(quoteProductsUpdated.getProducts().get(0).getRates().get(0).getIsOffered());
        quoteItem.setRateBasePremium(quoteProductsUpdated.getProducts().get(0).getRates().get(0).getBasePremium());
        quoteItem.setRateDiscount(quoteProductsUpdated.getProducts().get(0).getRates().get(0).getDiscount());
        quoteItem.setRateTotal(quoteProductsUpdated.getProducts().get(0).getRates().get(0).getTotal());
        quoteItem.setRateStatus(quoteProductsUpdated.getProducts().get(0).getRates().get(0).getStatus());

        return new QuoteItems();
    }
}
