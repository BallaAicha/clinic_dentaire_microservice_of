package org.etutoria.usersservice.services.impl;

import lombok.AllArgsConstructor;

import org.etutoria.usersservice.entities.Role;
import org.etutoria.usersservice.repositories.RoleDao;
import org.etutoria.usersservice.services.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;
    @Override
    public Role createRole(String roleName) {
        return roleDao.save(new Role(roleName));
    }
}
