package com.github.fggreeff.transformers;

import com.github.fggreeff.domains.QuoteStarted;
import org.junit.Assert;

public class TransformerTest {

    Transformer underTest;
    QuoteStarted quoteStarted;

    /**
     * @verifies convert event correctly
     *
     */
    @org.junit.Before
    public void setUp() throws Exception {
        underTest = new Transformer();
        quoteStarted = new QuoteStarted();
    }

    // TODO: Move json to a file in resources
    @org.junit.Test
    public void deserializeEvent() throws Exception {
        // Given
        final String inputEvent = "{\n" +
                "   \"id\":\"e3ae688a-ecee-48a5-8219-250f222e358d\",\n" +
                "   \"reference\":\"d6glop\",\n" +
                "   \"contact\":{\n" +
                "      \"firstName\":\"Darron\",\n" +
                "      \"businessType\":\"sole\",\n" +
                "      \"industry\":[\n" +
                "\n" +
                "      ],\n" +
                "      \"turnover\":50000\n" +
                "   },\n" +
                "   \"timestamp\":\"2020-03-23T12:53:32+00:00\",\n" +
                "   \"isFirstQuote\":true\n" +
                "}";

        // When
        QuoteStarted expectedDeserializeEvent = (QuoteStarted) underTest.deserializeEvent(inputEvent, QuoteStarted.class);

        // Then
        quoteStarted.setId("e3ae688a-ecee-48a5-8219-250f222e358d");
        quoteStarted.setReference("d6glop");
        quoteStarted.setTimestamp("2020-03-23T12:53:32+00:00");
        quoteStarted.setIsFirstQuote(true);

        Assert.assertEquals(expectedDeserializeEvent, quoteStarted);
    }
}