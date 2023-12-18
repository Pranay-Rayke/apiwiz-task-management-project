package com.example.taskmanagementapi.DTO.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserRequestDto {

    String username;

    String password;

    boolean isAdmin;

}
