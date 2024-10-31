package org.etutoria.usersservice.services.impl;

import lombok.AllArgsConstructor;
import org.etutoria.usersservice.entities.Role;
import org.etutoria.usersservice.entities.User;
import org.etutoria.usersservice.repositories.RoleDao;
import org.etutoria.usersservice.repositories.UserDao;
import org.etutoria.usersservice.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final RoleDao roleDao;

    @Override
    public User loadUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User createUser(String email, String password) {
        return userDao.save(new User(email, password));
    }

    @Override
    public void assignRoleToUser(String email, String roleName) {
        User user = loadUserByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Role role = roleDao.findByName(roleName);
        if (role == null) {
            role = new Role(roleName);
            role = roleDao.save(role);
        }

        user.assignRoleToUser(role);
        userDao.save(user);
    }
}