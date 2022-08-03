package com.codegym.casestudy.service.employee.impl;

import com.codegym.casestudy.model.employee.User;
import com.codegym.casestudy.repository.employee.IUserRepository;
import com.codegym.casestudy.service.employee.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public List<User> findAll() {
        return iUserRepository.findAllUser();
    }
}
