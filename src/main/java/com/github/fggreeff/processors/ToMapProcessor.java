package com.github.fggreeff.processors;

import com.github.fggreeff.akkaspring.SpringExtension;
import com.github.fggreeff.domains.QuoteProductsUpdated;
import com.github.fggreeff.domains.QuoteStarted;
import com.github.fggreeff.models.Quote;
import com.github.fggreeff.models.QuoteItems;
import com.github.fggreeff.models.QuoteRepository;
import com.github.fggreeff.transformers.EventToQuote;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
//@ComponentScan
@Component
public class ToMapProcessor {

    private static final Logger log = LoggerFactory.getLogger(ToMapProcessor.class);

    @Autowired
    private QuoteRepository quoteRepository;
    private EventToQuote event = new EventToQuote();


    public void processQuoteStarted(QuoteStarted quoteStarted, String eventType){
        Quote quote = event.quoteStarted(quoteStarted, eventType);
        quoteRepository.save(quote); // TODO: Spring should wire this up with akka
    }

    public void processQuoteStarted(QuoteProductsUpdated quoteProductsUpdated){
        QuoteItems quoteItems = event.quoteProductsUpdated(quoteProductsUpdated);
        //quoteRepository.save(quote);
    }
}

