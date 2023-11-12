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
 * Information to create a new wallet.
 */

@Schema(name = "WalletCreationRequest", description = "Information to create a new wallet.")
@JsonTypeName("WalletCreationRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-11T14:49:52.070439600+01:00[Europe/Madrid]")
public class WalletCreationRequestDTO {

  private Long ownerId;

  private Double balance;

  public WalletCreationRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public WalletCreationRequestDTO(Long ownerId, Double balance) {
    this.ownerId = ownerId;
    this.balance = balance;
  }

  public WalletCreationRequestDTO ownerId(Long ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * The unique identifier of the user owner of the wallet.
   * @return ownerId
  */
  @NotNull 
  @Schema(name = "owner_id", example = "11", description = "The unique identifier of the user owner of the wallet.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("owner_id")
  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  public WalletCreationRequestDTO balance(Double balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Initial amount of the wallet.
   * @return balance
  */
  @NotNull 
  @Schema(name = "balance", example = "100.0", description = "Initial amount of the wallet.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("balance")
  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletCreationRequestDTO walletCreationRequest = (WalletCreationRequestDTO) o;
    return Objects.equals(this.ownerId, walletCreationRequest.ownerId) &&
        Objects.equals(this.balance, walletCreationRequest.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownerId, balance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletCreationRequestDTO {\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

