package com.github.fggreeff.controller;

import com.github.fggreeff.models.Quote;
import com.github.fggreeff.models.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Controller
public class QuoteController {

    private static final Instant INSTANT = Instant.now();
    private static final Long TIMESTAMP_MILLIS = INSTANT.getEpochSecond();
    private static final LocalDateTime NOW_DATE_TIME = LocalDateTime.ofInstant(Instant.ofEpochSecond(TIMESTAMP_MILLIS), ZoneOffset.UTC);

    @Autowired
    private QuoteRepository quoteRepository;

    // TODO: Move this logic, only used for testing the creation of the table in sql
    @RequestMapping("/")
    @ResponseBody
    public void setQuote() {

        Quote quote = new Quote();
        quote.setId(1);
        quote.setEventType("Update_insurance");
        quote.setQuoteUID("11-22");
        quote.setCreatedAt(NOW_DATE_TIME);

        quoteRepository.save(quote);
    }
}
