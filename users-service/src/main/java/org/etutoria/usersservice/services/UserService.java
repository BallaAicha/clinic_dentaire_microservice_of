package org.etutoria.usersservice.services;


import org.etutoria.usersservice.entities.User;

public interface UserService {
    User loadUserByEmail(String email);

    User createUser(String email, String password);

    void assignRoleToUser(String email, String roleName);
}
