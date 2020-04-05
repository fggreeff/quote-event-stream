package com.github.fggreeff.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;

import java.util.List;

// quote_products_updated
@Data
@Getter
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @JsonProperty("id")
    public String id;
    @JsonProperty("key")
    public String key;
    @JsonProperty("name")
    public String name;
    @JsonProperty("rates")
    public List<Rate> rates = null;
}
