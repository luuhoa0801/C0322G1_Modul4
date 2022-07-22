package com.codegym.form_user.service;

import com.codegym.form_user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    Page<User> getAll(Pageable pageable);

    void create(User user);
}
