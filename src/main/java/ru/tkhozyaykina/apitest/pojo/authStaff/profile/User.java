
package ru.tkhozyaykina.apitest.pojo.authStaff.profile;

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
    "first_name",
    "email",
    "id",
    "role",
    "is_staff",
    "last_name"
})
public class User {

    /**
     * The First_name Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("first_name")
    private String firstName = "";
    /**
     * The Email Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("email")
    private String email = "";
    /**
     * The Id Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("id")
    private Integer id = 0;
    /**
     * The Role Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("role")
    private String role = "";
    /**
     * The Is_staff Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("is_staff")
    private Boolean isStaff = false;
    /**
     * The Last_name Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("last_name")
    private String lastName = "";
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The First_name Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * The First_name Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * The Email Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * The Email Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * The Id Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * The Id Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public User withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * The Role Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * The Role Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    public User withRole(String role) {
        this.role = role;
        return this;
    }

    /**
     * The Is_staff Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("is_staff")
    public Boolean getIsStaff() {
        return isStaff;
    }

    /**
     * The Is_staff Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("is_staff")
    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public User withIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
        return this;
    }

    /**
     * The Last_name Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * The Last_name Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
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

    public User withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("firstName", firstName).append("email", email).append("id", id).append("role", role).append("isStaff", isStaff).append("lastName", lastName).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(lastName).append(role).append(isStaff).append(id).append(additionalProperties).append(email).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return new EqualsBuilder().append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(role, rhs.role).append(isStaff, rhs.isStaff).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(email, rhs.email).isEquals();
    }

}
