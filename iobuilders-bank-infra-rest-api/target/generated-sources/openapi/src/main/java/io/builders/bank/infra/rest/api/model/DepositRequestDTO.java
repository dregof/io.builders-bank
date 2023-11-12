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
 * Information about a deposit.
 */

@Schema(name = "DepositRequest", description = "Information about a deposit.")
@JsonTypeName("DepositRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-11T14:49:52.070439600+01:00[Europe/Madrid]")
public class DepositRequestDTO {

  private Long destinationWalletId;

  private Double amount;

  public DepositRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DepositRequestDTO(Long destinationWalletId, Double amount) {
    this.destinationWalletId = destinationWalletId;
    this.amount = amount;
  }

  public DepositRequestDTO destinationWalletId(Long destinationWalletId) {
    this.destinationWalletId = destinationWalletId;
    return this;
  }

  /**
   * The fiscal name of the destination wallet.
   * @return destinationWalletId
  */
  @NotNull 
  @Schema(name = "destination_wallet_id", example = "123", description = "The fiscal name of the destination wallet.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("destination_wallet_id")
  public Long getDestinationWalletId() {
    return destinationWalletId;
  }

  public void setDestinationWalletId(Long destinationWalletId) {
    this.destinationWalletId = destinationWalletId;
  }

  public DepositRequestDTO amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Amount that is being deposited.
   * @return amount
  */
  @NotNull 
  @Schema(name = "amount", example = "100.0", description = "Amount that is being deposited.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DepositRequestDTO depositRequest = (DepositRequestDTO) o;
    return Objects.equals(this.destinationWalletId, depositRequest.destinationWalletId) &&
        Objects.equals(this.amount, depositRequest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationWalletId, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DepositRequestDTO {\n");
    sb.append("    destinationWalletId: ").append(toIndentedString(destinationWalletId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

