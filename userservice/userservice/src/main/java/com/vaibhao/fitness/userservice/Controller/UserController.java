package com.vaibhao.fitness.userservice.Controller;

import com.vaibhao.fitness.userservice.DTO.Request.RegisterRequest;
import com.vaibhao.fitness.userservice.DTO.Response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.vaibhao.fitness.userservice.Service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

  private final UserService userService;

  @GetMapping("/{userId}")
  public ResponseEntity<UserResponse> getUserProfile(@PathVariable Long userId) {
    return ResponseEntity.ok(userService.getUserProfile(userId));
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<UserResponse>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @PostMapping("register")
  public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest registerRequest){
    return ResponseEntity.ok(userService.register(registerRequest));
  }

  @GetMapping("/{userId}/validate")
  public ResponseEntity<Boolean> validateUser(@PathVariable Long userId) {
    return ResponseEntity.ok(userService.existByUserId(userId));

  }
}
