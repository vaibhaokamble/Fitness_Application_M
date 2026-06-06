package com.vaibhao.fitness.userservice.Service;

import com.vaibhao.fitness.userservice.DTO.Request.RegisterRequest;
import com.vaibhao.fitness.userservice.DTO.Response.UserResponse;
import com.vaibhao.fitness.userservice.Model.UserModel;
import com.vaibhao.fitness.userservice.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest registerRequest) {
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        UserModel userModel = new UserModel();

        userModel.setEmail(registerRequest.getEmail());
        userModel.setPassword(registerRequest.getPassword());
        userModel.setFirstName(registerRequest.getFirstName());
        userModel.setLastName(registerRequest.getLastName());

        UserModel savedUser = userRepository.save(userModel);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());

        return userResponse;
    }

    public UserResponse getUserProfile(Long userId) {
        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserResponse userResponse = new UserResponse();
        userResponse.setId(userModel.getId());
        userResponse.setEmail(userModel.getEmail());
        userResponse.setPassword(userModel.getPassword());
        userResponse.setFirstName(userModel.getFirstName());
        userResponse.setLastName(userModel.getLastName());
        userResponse.setCreatedAt(userModel.getCreatedAt());
        userResponse.setUpdatedAt(userModel.getUpdatedAt());

        return userResponse;
    }


    public List<UserResponse> getAllUsers() {
        List<UserResponse> userResponseList = new ArrayList<>();
        List<UserModel> userModelList = userRepository.findAll();
        for (UserModel userModel : userModelList) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(userModel.getId());
            userResponse.setEmail(userModel.getEmail());
            userResponse.setFirstName(userModel.getFirstName());
            userResponse.setLastName(userModel.getLastName());
            userResponse.setCreatedAt(userModel.getCreatedAt());
            userResponse.setUpdatedAt(userModel.getUpdatedAt());

            userResponseList.add(userResponse);
        }
        return userResponseList;
    }

    public Boolean existByUserId(Long userId) {
        return userRepository.existsById(userId);
    }
}
