package com.github.fggreeff.processors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactUpdated {

    @JsonProperty("industry")
    public List<Industry> industry = null;
    @JsonProperty("turnover")
    public Integer turnover;
    @JsonProperty("employeeCount")
    public Integer employeeCount;
    @JsonProperty("hasActiveInsurance")
    public Boolean hasActiveInsurance;
    @JsonProperty("activeInsuranceRenewalDate")
    public Object activeInsuranceRenewalDate;
    @JsonProperty("effectiveDate")
    public String effectiveDate;

    @JsonProperty("isValidBusiness") // Only exists in ContactUpdated event (Not in contact class / QuoteStarted event)
    public Boolean isValidBusiness;
    @JsonProperty("quoteId") // This is id in QuoteStarted class
    public String quoteId;
    @JsonProperty("timestamp") // This is timestamp in QuoteStarted class
    public String timestamp;

}


