package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.Role;
import com.example.furniturefabrica.entity.User;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.UserDto;
import com.example.furniturefabrica.repositories.RoleRepository;
import com.example.furniturefabrica.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public ApiResponse addUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setPhone(userDto.getPhone());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Optional<Role> optionalRole = roleRepository.findById(userDto.getRoleId());
        Role role = optionalRole.get();
        if (!optionalRole.isPresent()) {
            return new ApiResponse("Not found", false);
        }
        user.setEnabled(true);
        user.setRole(role);
        userRepository.save(user);
        return new ApiResponse("Saved", true);
    }

    public ApiResponse editUser(UserDto userDto, long id) {
        Optional<User> byId = userRepository.findById((int) id);
        if (!byId.isPresent()) return new ApiResponse("Not found", false);
        User user = byId.get();
        user.setFirstName(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setPhone(userDto.getPhone());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        Optional<Role> optionalRole = roleRepository.findById(userDto.getRoleId());
        Role role = optionalRole.get();
        if (!optionalRole.isPresent()) {
            return new ApiResponse("Not found", false);
        }
        user.setRole(role);
        user.setEnabled(true);
        userRepository.save(user);
        return new ApiResponse("Edited", true);
    }

    public ApiResponse deleteUser(long id) {
        boolean exists = userRepository.existsById((int) id);
        if (!exists) return new ApiResponse("Not found", false);
        userRepository.deleteById((int) id);
        return new ApiResponse("Deleted", true);
    }

    public ApiResponse getOne(long id) {
        Optional<User> byId = userRepository.findById((int) id);
        if (!byId.isPresent()) return new ApiResponse("Not found", false);
        User user = byId.get();
        return new ApiResponse("OK", true, user);
    }

    public List<User> getall() {
        List<User> all = userRepository.findAll();
        return all;
    }
}
