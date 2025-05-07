package com.barbirms.service.implementations;

import com.barbirms.infrastructure.entities.User;
import com.barbirms.infrastructure.repositories.UserRepository;
import com.barbirms.service.DTOs.UserDTO;
import com.barbirms.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository _repository;

    public void CreateUser (String username, String password) {
        User user = new User(username, password);
        _repository.save(user);
    }

    public UserDTO GetUserInfo (String username) {
        return new UserDTO(_repository.getUserByUsername(username));
    }

    public List<UserDTO> GetAllUsers(){
        return _repository.findAll().stream().map(this::UserToDTO).collect(Collectors.toList());
    }

    private UserDTO UserToDTO (User user) {
        return new UserDTO(user);
    }

}
