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
 * Information about a transference
 */

@Schema(name = "TransferRequest", description = "Information about a transference")
@JsonTypeName("TransferRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-11T14:49:52.070439600+01:00[Europe/Madrid]")
public class TransferRequestDTO {

  private Long originWalletId;

  private Long destinationWalletId;

  private Double amount;

  public TransferRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TransferRequestDTO(Long originWalletId, Long destinationWalletId, Double amount) {
    this.originWalletId = originWalletId;
    this.destinationWalletId = destinationWalletId;
    this.amount = amount;
  }

  public TransferRequestDTO originWalletId(Long originWalletId) {
    this.originWalletId = originWalletId;
    return this;
  }

  /**
   * Unique identifier of the origin wallet.
   * @return originWalletId
  */
  @NotNull 
  @Schema(name = "origin_wallet_id", example = "111", description = "Unique identifier of the origin wallet.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("origin_wallet_id")
  public Long getOriginWalletId() {
    return originWalletId;
  }

  public void setOriginWalletId(Long originWalletId) {
    this.originWalletId = originWalletId;
  }

  public TransferRequestDTO destinationWalletId(Long destinationWalletId) {
    this.destinationWalletId = destinationWalletId;
    return this;
  }

  /**
   * The fiscal name of the destination wallet.
   * @return destinationWalletId
  */
  @NotNull 
  @Schema(name = "destination_wallet_id", example = "222", description = "The fiscal name of the destination wallet.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("destination_wallet_id")
  public Long getDestinationWalletId() {
    return destinationWalletId;
  }

  public void setDestinationWalletId(Long destinationWalletId) {
    this.destinationWalletId = destinationWalletId;
  }

  public TransferRequestDTO amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Amount that is being transferred.
   * @return amount
  */
  @NotNull 
  @Schema(name = "amount", example = "100.0", description = "Amount that is being transferred.", requiredMode = Schema.RequiredMode.REQUIRED)
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
    TransferRequestDTO transferRequest = (TransferRequestDTO) o;
    return Objects.equals(this.originWalletId, transferRequest.originWalletId) &&
        Objects.equals(this.destinationWalletId, transferRequest.destinationWalletId) &&
        Objects.equals(this.amount, transferRequest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originWalletId, destinationWalletId, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferRequestDTO {\n");
    sb.append("    originWalletId: ").append(toIndentedString(originWalletId)).append("\n");
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

