package com.example.taskmanagementapi.Transformer;

import com.example.taskmanagementapi.DTO.RequestDto.UserRequestDto;
import com.example.taskmanagementapi.DTO.ResponseDto.UserResponseDto;
import com.example.taskmanagementapi.Entity.User;

public class UserTransformer {

    public static User UserRequestDtoToUser(UserRequestDto userRequestDto)
    {
        return User.builder()
                .password(userRequestDto.getPassword())
                .isAdmin(userRequestDto.isAdmin())
                .username(userRequestDto.getUsername())
                .build();
    }

    public static UserResponseDto UserToUserResponseDto(User user)
    {
        return UserResponseDto.builder()
                .username(user.getUsername())
                .isAdmin(user.isAdmin())
                .build();
    }
}
