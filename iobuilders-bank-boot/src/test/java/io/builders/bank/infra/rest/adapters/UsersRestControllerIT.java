package io.builders.bank.infra.rest.adapters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

import io.builders.bank.infra.rest.api.model.UserInformationDTO;
import io.builders.bank.infra.rest.api.model.UserCreationRequestDTO;
import io.builders.bank.config.TestIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

class UsersRestControllerIT extends TestIT {

    @Autowired
    private UsersRestController usersRestController;

    @Test
    void createUserAndFindSuccessfully() {
        final UserCreationRequestDTO requestDto = new UserCreationRequestDTO()
                .name("Rafael Nadal")
                .email("rafa.nadal@gmail.com")
                .fiscalAddress("Cales de Mallorca s/n, Km 1,2, 07500 Manacor")
                .nif("37342165D");

        final ResponseEntity<UserInformationDTO> creationResponse = this.usersRestController.createUser(requestDto);

        assertThat(creationResponse.getStatusCode()).isEqualTo(OK);
        assertThat(creationResponse.getBody()).isNotNull();
        assertThat(creationResponse.getBody().getId()).isNotNull();

        final ResponseEntity<UserInformationDTO> userFound = this.usersRestController.findUserById(
                creationResponse.getBody().getId());

        assertThat(userFound.getStatusCode()).isEqualTo(OK);
        assertThat(userFound.getBody()).isNotNull();
        assertThat(userFound.getBody().getId()).isEqualTo(creationResponse.getBody().getId());
        assertThat(userFound.getBody().getName()).isEqualTo(requestDto.getName());
        assertThat(userFound.getBody().getEmail()).isEqualTo(requestDto.getEmail());
        assertThat(userFound.getBody().getFiscalAddress()).isEqualTo(requestDto.getFiscalAddress());
        assertThat(userFound.getBody().getNif()).isEqualTo(requestDto.getNif());
    }

}