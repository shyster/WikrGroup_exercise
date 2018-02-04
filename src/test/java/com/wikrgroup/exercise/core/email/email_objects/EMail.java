package com.wikrgroup.exercise.core.email.email_objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_id",
        "createdAt",
        "mail_id",
        "mail_address_id",
        "mail_from",
        "mail_subject",
        "mail_preview",
        "mail_text_only",
        "mail_text",
        "mail_html",
        "mail_timestamp"
})
public class EMail {

    @JsonProperty("_id")
    private Id id;
    @JsonProperty("createdAt")
    private CreatedAt createdAt;
    @JsonProperty("mail_id")
    private String mailId;
    @JsonProperty("mail_address_id")
    private String mailAddressId;
    @JsonProperty("mail_from")
    private String mailFrom;
    @JsonProperty("mail_subject")
    private String mailSubject;
    @JsonProperty("mail_preview")
    private String mailPreview;
    @JsonProperty("mail_text_only")
    private String mailTextOnly;
    @JsonProperty("mail_text")
    private String mailText;
    @JsonProperty("mail_html")
    private String mailHtml;
    @JsonProperty("mail_timestamp")
    private Double mailTimestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("_id")
    public Id getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(Id id) {
        this.id = id;
    }

    @JsonProperty("createdAt")
    public CreatedAt getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(CreatedAt createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("mail_id")
    public String getMailId() {
        return mailId;
    }

    @JsonProperty("mail_id")
    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    @JsonProperty("mail_address_id")
    public String getMailAddressId() {
        return mailAddressId;
    }

    @JsonProperty("mail_address_id")
    public void setMailAddressId(String mailAddressId) {
        this.mailAddressId = mailAddressId;
    }

    @JsonProperty("mail_from")
    public String getMailFrom() {
        return mailFrom;
    }

    @JsonProperty("mail_from")
    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    @JsonProperty("mail_subject")
    public String getMailSubject() {
        return mailSubject;
    }

    @JsonProperty("mail_subject")
    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    @JsonProperty("mail_preview")
    public String getMailPreview() {
        return mailPreview;
    }

    @JsonProperty("mail_preview")
    public void setMailPreview(String mailPreview) {
        this.mailPreview = mailPreview;
    }

    @JsonProperty("mail_text_only")
    public String getMailTextOnly() {
        return mailTextOnly;
    }

    @JsonProperty("mail_text_only")
    public void setMailTextOnly(String mailTextOnly) {
        this.mailTextOnly = mailTextOnly;
    }

    @JsonProperty("mail_text")
    public String getMailText() {
        return mailText;
    }

    @JsonProperty("mail_text")
    public void setMailText(String mailText) {
        this.mailText = mailText;
    }

    @JsonProperty("mail_html")
    public String getMailHtml() {
        return mailHtml;
    }

    @JsonProperty("mail_html")
    public void setMailHtml(String mailHtml) {
        this.mailHtml = mailHtml;
    }

    @JsonProperty("mail_timestamp")
    public Double getMailTimestamp() {
        return mailTimestamp;
    }

    @JsonProperty("mail_timestamp")
    public void setMailTimestamp(Double mailTimestamp) {
        this.mailTimestamp = mailTimestamp;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EMail eMail = (EMail) o;

        if (!id.equals(eMail.id)) return false;
        if (!createdAt.equals(eMail.createdAt)) return false;
        if (!mailId.equals(eMail.mailId)) return false;
        if (!mailAddressId.equals(eMail.mailAddressId)) return false;
        if (!mailFrom.equals(eMail.mailFrom)) return false;
        if (mailSubject != null ? !mailSubject.equals(eMail.mailSubject) : eMail.mailSubject != null) return false;
        if (mailPreview != null ? !mailPreview.equals(eMail.mailPreview) : eMail.mailPreview != null) return false;
        if (mailTextOnly != null ? !mailTextOnly.equals(eMail.mailTextOnly) : eMail.mailTextOnly != null) return false;
        if (mailText != null ? !mailText.equals(eMail.mailText) : eMail.mailText != null) return false;
        if (mailHtml != null ? !mailHtml.equals(eMail.mailHtml) : eMail.mailHtml != null) return false;
        return mailTimestamp != null ? mailTimestamp.equals(eMail.mailTimestamp) : eMail.mailTimestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + mailId.hashCode();
        result = 31 * result + mailAddressId.hashCode();
        result = 31 * result + mailFrom.hashCode();
        result = 31 * result + (mailSubject != null ? mailSubject.hashCode() : 0);
        result = 31 * result + (mailPreview != null ? mailPreview.hashCode() : 0);
        result = 31 * result + (mailTextOnly != null ? mailTextOnly.hashCode() : 0);
        result = 31 * result + (mailText != null ? mailText.hashCode() : 0);
        result = 31 * result + (mailHtml != null ? mailHtml.hashCode() : 0);
        result = 31 * result + (mailTimestamp != null ? mailTimestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EMail{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", mailId='" + mailId + '\'' +
                ", mailAddressId='" + mailAddressId + '\'' +
                ", mailFrom='" + mailFrom + '\'' +
                ", mailSubject='" + mailSubject + '\'' +
                ", mailPreview='" + mailPreview + '\'' +
                ", mailTextOnly='" + mailTextOnly + '\'' +
                ", mailText='" + mailText + '\'' +
                ", mailHtml='" + mailHtml + '\'' +
                ", mailTimestamp=" + mailTimestamp +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
