package io.builders.bank.infra.rest.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Information relative to an user
 */

@Schema(name = "UserInformation", description = "Information relative to an user")
@JsonTypeName("UserInformation")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-11T14:49:52.070439600+01:00[Europe/Madrid]")
public class UserInformationDTO {

  private String name;

  private String email;

  private String fiscalAddress;

  private String nif;

  private Long id;

  public UserInformationDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserInformationDTO(String name, String email, String fiscalAddress, String nif, Long id) {
    this.name = name;
    this.email = email;
    this.fiscalAddress = fiscalAddress;
    this.nif = nif;
    this.id = id;
  }

  public UserInformationDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Full name.
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Rafael Nadal", description = "Full name.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserInformationDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email address.
   * @return email
  */
  @NotNull 
  @Schema(name = "email", example = "rafa.nadal@gmail.com", description = "Email address.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserInformationDTO fiscalAddress(String fiscalAddress) {
    this.fiscalAddress = fiscalAddress;
    return this;
  }

  /**
   * Fiscal address.
   * @return fiscalAddress
  */
  @NotNull 
  @Schema(name = "fiscal_address", example = "Cales de Mallorca s/n, Km 1,2, 07500 Manacor", description = "Fiscal address.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fiscal_address")
  public String getFiscalAddress() {
    return fiscalAddress;
  }

  public void setFiscalAddress(String fiscalAddress) {
    this.fiscalAddress = fiscalAddress;
  }

  public UserInformationDTO nif(String nif) {
    this.nif = nif;
    return this;
  }

  /**
   * National identification number.
   * @return nif
  */
  @NotNull 
  @Schema(name = "nif", example = "37342165D", description = "National identification number.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nif")
  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  public UserInformationDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Auto-generated unique identifier of the user
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "11", description = "Auto-generated unique identifier of the user", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInformationDTO userInformation = (UserInformationDTO) o;
    return Objects.equals(this.name, userInformation.name) &&
        Objects.equals(this.email, userInformation.email) &&
        Objects.equals(this.fiscalAddress, userInformation.fiscalAddress) &&
        Objects.equals(this.nif, userInformation.nif) &&
        Objects.equals(this.id, userInformation.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, fiscalAddress, nif, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInformationDTO {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    fiscalAddress: ").append(toIndentedString(fiscalAddress)).append("\n");
    sb.append("    nif: ").append(toIndentedString(nif)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

