package com.github.fggreeff.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.Getter;

// quote_started
@Data
@Getter
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteStarted {

    @JsonProperty("id")
    private String id;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("isFirstQuote")
    private Boolean isFirstQuote;
}
