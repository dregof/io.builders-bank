package io.builders.bank.infra.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    private Long id;

    private String name;

    private String email;

    private String fiscalAddress;

    private String nif;

}