package com.codegym.form_user.service;

import com.codegym.form_user.model.User;
import com.codegym.form_user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<User> getAll(Pageable pageable) {
        return iUserRepository.findAllUser(pageable);
    }


    @Override
    public void create(User user) {
        iUserRepository.create(user.getFirstName(), user.getLastName(),
                user.getPhone(), user.getAge(), user.getEmail());
    }


}
