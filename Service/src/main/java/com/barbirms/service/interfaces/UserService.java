package com.barbirms.service.interfaces;

import com.barbirms.service.DTOs.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void CreateUser (String username, String password, String email);

    UserDTO GetUserInfo (String username);

    List<UserDTO> GetAllUsers();
}
