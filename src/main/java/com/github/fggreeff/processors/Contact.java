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
public class Contact {

    @JsonProperty("industry")
    private List<Industry> industry = null;
    @JsonProperty("turnover")
    private Integer turnover;
    @JsonProperty("employeeCount")
    private Integer employeeCount;
    @JsonProperty("hasActiveInsurance")
    private Boolean hasActiveInsurance;
    @JsonProperty("activeInsuranceRenewalDate")
    private Object activeInsuranceRenewalDate;
    @JsonProperty("effectiveDate")
    private String effectiveDate;
}