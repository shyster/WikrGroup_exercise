package com.wikrgroup.exercise.core.email.email_objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "$date"
})
public class CreatedAt {

    @JsonProperty("$date")
    private Date date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("$date")
    public Date getDate() {
        return date;
    }

    @JsonProperty("$date")
    public void set$date(Date date) {
        this.date = date;
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
        return "CreatedAt{" +
                "date=" + date +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
