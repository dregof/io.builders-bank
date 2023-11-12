package io.builders.bank.infra.rest.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.builders.bank.infra.rest.api.model.TransferRequestDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Information of a wallet.
 */

@Schema(name = "WalletInformation", description = "Information of a wallet.")
@JsonTypeName("WalletInformation")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-11T14:49:52.070439600+01:00[Europe/Madrid]")
public class WalletInformationDTO {

  private Long ownerId;

  private Double balance;

  private Long id;

  @Valid
  private List<@Valid TransferRequestDTO> movements = new ArrayList<>();

  public WalletInformationDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public WalletInformationDTO(Long ownerId, Double balance, Long id, List<@Valid TransferRequestDTO> movements) {
    this.ownerId = ownerId;
    this.balance = balance;
    this.id = id;
    this.movements = movements;
  }

  public WalletInformationDTO ownerId(Long ownerId) {
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

  public WalletInformationDTO balance(Double balance) {
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

  public WalletInformationDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Auto-generated unique identifier of the wallet
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "22", description = "Auto-generated unique identifier of the wallet", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public WalletInformationDTO movements(List<@Valid TransferRequestDTO> movements) {
    this.movements = movements;
    return this;
  }

  public WalletInformationDTO addMovementsItem(TransferRequestDTO movementsItem) {
    if (this.movements == null) {
      this.movements = new ArrayList<>();
    }
    this.movements.add(movementsItem);
    return this;
  }

  /**
   * Get movements
   * @return movements
  */
  @NotNull @Valid 
  @Schema(name = "movements", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("movements")
  public List<@Valid TransferRequestDTO> getMovements() {
    return movements;
  }

  public void setMovements(List<@Valid TransferRequestDTO> movements) {
    this.movements = movements;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletInformationDTO walletInformation = (WalletInformationDTO) o;
    return Objects.equals(this.ownerId, walletInformation.ownerId) &&
        Objects.equals(this.balance, walletInformation.balance) &&
        Objects.equals(this.id, walletInformation.id) &&
        Objects.equals(this.movements, walletInformation.movements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownerId, balance, id, movements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletInformationDTO {\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    movements: ").append(toIndentedString(movements)).append("\n");
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

