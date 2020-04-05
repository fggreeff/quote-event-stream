package com.github.fggreeff.processors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.Getter;

import java.util.List;
/*
@Data
@Getter
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgencyProduct {

    @JsonProperty("guid")
    public String guid;
    @JsonProperty("name")
    public String name;

}


public class Product {

    @JsonProperty("id")
    public String id;
    @JsonProperty("key")
    public String key;
    @JsonProperty("name")
    public String name;
    @JsonProperty("rates")
    public List<Rate> rates = null;
    @JsonProperty("agencyProduct")
    public AgencyProduct agencyProduct;
    @JsonProperty("total")
    public Float total;
    @JsonProperty("ipt")
    public Float ipt;

}


public class QuoteProductsUpdated {

    @JsonProperty("quoteId")
    public String quoteId;
    @JsonProperty("products")
    public List<Product> products = null;

}

public class Rate {

    @JsonProperty("key")
    public String key;
    @JsonProperty("description")
    public String description;
    @JsonProperty("isOffered")
    public Boolean isOffered;
    @JsonProperty("basePremium")
    public Float basePremium;
    @JsonProperty("loading")
    public Float loading;
    @JsonProperty("discount")
    public Object discount;
    @JsonProperty("ipt")
    public Float ipt;
    @JsonProperty("commission")
    public Float commission;
    @JsonProperty("ratingAttributes")
    public RatingAttributes ratingAttributes;
    @JsonProperty("ratingInputs")
    public RatingInputs ratingInputs;
    @JsonProperty("errors")
    public List<Object> errors = null;
    @JsonProperty("total")
    public Float total;
    @JsonProperty("status")
    public String status;

}


public class RatingAttributes {

    @JsonProperty("limit")
    public Integer limit;
    @JsonProperty("basePremiumPa")
    public Integer basePremiumPa;
    @JsonProperty("excess")
    public Integer excess;
    @JsonProperty("employeeCount")
    public Integer employeeCount;
    @JsonProperty("postcode")
    public Object postcode;
    @JsonProperty("endorsements")
    public List<String> endorsements = null;
    @JsonProperty("mpaAdjustmentPremium")
    public Integer mpaAdjustmentPremium;
    @JsonProperty("fixed_property_limit")
    public Integer fixedPropertyLimit;
    @JsonProperty("portable_property_limit")
    public Integer portablePropertyLimit;
    @JsonProperty("portable_property_jurisdiction")
    public String portablePropertyJurisdiction;
    @JsonProperty("portable_property_excess")
    public Integer portablePropertyExcess;
    @JsonProperty("portable_property_base_premium_pa")
    public Float portablePropertyBasePremiumPa;
    @JsonProperty("revenue_protection_limit")
    public Integer revenueProtectionLimit;
    @JsonProperty("money_assault_base_premium_pa")
    public Integer moneyAssaultBasePremiumPa;

}

public class RatingInputs {

    @JsonProperty("key")
    public String key;
    @JsonProperty("description")
    public String description;
    @JsonProperty("iptRate")
    public Float iptRate;
    @JsonProperty("commissionRate")
    public Float commissionRate;
    @JsonProperty("limit")
    public Integer limit;
    @JsonProperty("employeeCount")
    public Integer employeeCount;
    @JsonProperty("postcode")
    public Object postcode;
    @JsonProperty("industryId")
    public List<String> industryId = null;
    @JsonProperty("promocode")
    public List<Object> promocode = null;
    @JsonProperty("fixedPropertyLimit")
    public Integer fixedPropertyLimit;
    @JsonProperty("portablePropertyLimit")
    public Integer portablePropertyLimit;
    @JsonProperty("portablePropertyJurisdiction")
    public String portablePropertyJurisdiction;
    @JsonProperty("revenueProtectionLimit")
    public Integer revenueProtectionLimit;
    @JsonProperty("moneyAssaultActive")
    public Integer moneyAssaultActive;

}
*/