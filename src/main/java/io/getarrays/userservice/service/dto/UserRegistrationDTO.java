package io.getarrays.userservice.service.dto;

import lombok.Data;

@Data
public class UserRegistrationDTO {
    private String name;
    private String username;
    private String password;
}
