package com.TechDhiraj.DemoH2DB.service;

import com.TechDhiraj.DemoH2DB.dto.AddressDTO;
import com.TechDhiraj.DemoH2DB.dto.UserDTO;
import com.TechDhiraj.DemoH2DB.entity.User;
import com.TechDhiraj.DemoH2DB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddresses((List<AddressDTO>) user.getAddresses().stream().map(address -> {
            AddressDTO addressDTO= new AddressDTO();
            addressDTO.setId(address.getId());
            addressDTO.setStreet(address.getStreet());
            addressDTO.setCity(address.getCity());
            return addressDTO;
        }).collect(Collectors.toList()));
        return userDTO;
    }
    }
