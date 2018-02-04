package com.wikrgroup.exercise.core.email.email_objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "$numberLong"
})
public class Date {

    @JsonProperty("$numberLong")
    private String numberLong;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("$numberLong")
    public String get$numberLong() {
        return numberLong;
    }

    @JsonProperty("$numberLong")
    public void setNumberLong(String numberLong) {
        this.numberLong = numberLong;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Date{" +
                "numberLong='" + numberLong + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
