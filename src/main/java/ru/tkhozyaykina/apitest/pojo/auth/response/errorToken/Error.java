
package ru.tkhozyaykina.apitest.pojo.auth.response.errorToken;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "description"
})
public class Error {

    /**
     * The Code Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("code")
    private String code = "";
    /**
     * The Description Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("description")
    private String description = "";
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The Code Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * The Code Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public Error withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * The Description Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * The Description Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Error withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Error withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("description", description).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(description).append(code).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Error) == false) {
            return false;
        }
        Error rhs = ((Error) other);
        return new EqualsBuilder().append(description, rhs.description).append(code, rhs.code).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
