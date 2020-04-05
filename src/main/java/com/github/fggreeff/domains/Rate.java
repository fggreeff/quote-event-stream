package com.github.fggreeff.domains;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.Getter;

// quote_products_updated
@Data
@Getter
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {

    @JsonProperty("key")
    public String key;
    @JsonProperty("isOffered")
    public Boolean isOffered;
    @JsonProperty("basePremium")
    public Float basePremium;
    @JsonProperty("discount")
    public Object discount;
    @JsonProperty("total")
    public Float total;
    @JsonProperty("status")
    public String status;

}