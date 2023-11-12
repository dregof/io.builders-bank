/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package io.builders.bank.infra.rest.api;

import io.builders.bank.infra.rest.api.model.ErrorDTO;
import io.builders.bank.infra.rest.api.model.UserCreationRequestDTO;
import io.builders.bank.infra.rest.api.model.UserInformationDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-11T14:49:52.070439600+01:00[Europe/Madrid]")
@Validated
@Tag(name = "Users", description = "Allowed users´s operations.")
public interface UsersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/users : Create a user
     *
     * @param userCreationRequestDTO User&#39;s information to be created. (required)
     * @return Information about an user. (status code 200)
     *         or Bad Request. (status code 400)
     *         or Internal Server Error. (status code 500)
     */
    @Operation(
        operationId = "createUser",
        summary = "Create a user",
        tags = { "Users" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Information about an user.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserInformationDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/users",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserInformationDTO> _createUser(
        @Parameter(name = "UserCreationRequestDTO", description = "User's information to be created.", required = true) @Valid @RequestBody UserCreationRequestDTO userCreationRequestDTO
    ) {
        return createUser(userCreationRequestDTO);
    }

    // Override this method
    default  ResponseEntity<UserInformationDTO> createUser(UserCreationRequestDTO userCreationRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/users/{user_id} : Retrieve user&#39;s information by its ID.
     *
     * @param userId Unique identifier of an user (required)
     * @return Information about an user. (status code 200)
     *         or Bad Request. (status code 400)
     *         or Not Found. (status code 404)
     */
    @Operation(
        operationId = "findUserById",
        summary = "Retrieve user's information by its ID.",
        tags = { "Users" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Information about an user.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserInformationDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/users/{user_id}",
        produces = { "application/json" }
    )
    default ResponseEntity<UserInformationDTO> _findUserById(
        @Parameter(name = "user_id", description = "Unique identifier of an user", required = true, in = ParameterIn.PATH) @PathVariable("user_id") Long userId
    ) {
        return findUserById(userId);
    }

    // Override this method
    default  ResponseEntity<UserInformationDTO> findUserById(Long userId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}