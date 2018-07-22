
package ru.tkhozyaykina.apitest.pojo.auth.response.errorValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "field1",
    "field2"
})
public class Description {

    @JsonProperty("field1")
    private List<String> field1 = new ArrayList<String>();
    @JsonProperty("field2")
    private List<String> field2 = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("field1")
    public List<String> getField1() {
        return field1;
    }

    @JsonProperty("field1")
    public void setField1(List<String> field1) {
        this.field1 = field1;
    }

    public Description withField1(List<String> field1) {
        this.field1 = field1;
        return this;
    }

    @JsonProperty("field2")
    public List<String> getField2() {
        return field2;
    }

    @JsonProperty("field2")
    public void setField2(List<String> field2) {
        this.field2 = field2;
    }

    public Description withField2(List<String> field2) {
        this.field2 = field2;
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

    public Description withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("field1", field1).append("field2", field2).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(field1).append(additionalProperties).append(field2).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Description) == false) {
            return false;
        }
        Description rhs = ((Description) other);
        return new EqualsBuilder().append(field1, rhs.field1).append(additionalProperties, rhs.additionalProperties).append(field2, rhs.field2).isEquals();
    }

}
