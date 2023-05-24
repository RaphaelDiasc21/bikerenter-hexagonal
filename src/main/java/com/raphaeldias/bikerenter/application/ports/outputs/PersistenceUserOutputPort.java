package com.raphaeldias.bikerenter.application.ports.outputs;

import com.raphaeldias.bikerenter.application.domain.User;

import java.util.List;

public interface PersistenceUserOutputPort {
    User save(User user);
    List<User> listAll();
    User findById(Integer id);
    void deleteById(Integer id);
}
