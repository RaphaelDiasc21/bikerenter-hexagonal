package com.raphaeldias.bikerenter.application.ports.inputs;

import com.raphaeldias.bikerenter.application.domain.User;

import java.util.List;

public interface UserInputPort {
    User save(User user);
    public List<User> listAll();
    User findById(Integer id);
    void deleteById(Integer id);
    User updateUser(User user);
}
