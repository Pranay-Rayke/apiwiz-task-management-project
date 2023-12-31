package com.example.taskmanagementapi.Service.Implementation;

import com.example.taskmanagementapi.CustomException.UserNameAlreadyExistsException;
import com.example.taskmanagementapi.CustomException.UserNotFoundException;
import com.example.taskmanagementapi.DTO.RequestDto.UserRequestDto;
import com.example.taskmanagementapi.DTO.ResponseDto.UserResponseDto;
import com.example.taskmanagementapi.Entity.User;
import com.example.taskmanagementapi.Repository.UserRepository;
import com.example.taskmanagementapi.Service.UserServiceInterface;
import com.example.taskmanagementapi.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequestDto userRequestDto) throws UserNameAlreadyExistsException {
        User user = UserTransformer.UserRequestDtoToUser(userRequestDto);
        User user1 = userRepository.findByUsername(user.getUsername());
        if (user1 != null) {
            throw new UserNameAlreadyExistsException("Username already exists");
        }
        return userRepository.save(user);
    }

    public UserResponseDto getUserById(Long userId) throws UserNotFoundException {

        User user = userRepository.findById(userId).get();

        if(user == null)
        {
            throw new UserNotFoundException("User Not Found !!!");
        }

        UserResponseDto userResponseDto = UserTransformer.UserToUserResponseDto(user);
        return userResponseDto;
    }

    public UserResponseDto getUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null)
        {
            throw new UserNotFoundException("User Not Found !!!");
        }
        UserResponseDto userResponseDto = UserTransformer.UserToUserResponseDto(user);
        return userResponseDto;
    }
}