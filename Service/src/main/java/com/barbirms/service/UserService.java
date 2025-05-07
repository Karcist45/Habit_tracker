package com.barbirms.service;

import com.barbirms.infrastructure.entities.User;
import com.barbirms.service.DTOs.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public void CreateUser (String username, String password);

    public UserDTO GetUserInfo (String username);

    public List<UserDTO> GetAllUsers();
}
