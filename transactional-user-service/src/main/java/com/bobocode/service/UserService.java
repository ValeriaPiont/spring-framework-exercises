package com.bobocode.service;

import com.bobocode.dao.UserDao;
import com.bobocode.model.jpa.Role;
import com.bobocode.model.jpa.RoleType;
import com.bobocode.model.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * This class proovides {@link User} related service logic.
 */

@Service
@Transactional
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<User> getAllAdmins() {
       return  userDao.findAll()
               .stream()
               .filter(user -> user.getRoles()
                       .stream()
                       .anyMatch(role -> role.getRoleType() == RoleType.ADMIN))
               .collect(Collectors.toList());
    }

    public void addRole(Long userId, RoleType roleType) {
        User user = userDao.findById(userId);
        Role role = Role.valueOf(roleType);
        user.addRole(role);
    }
}
