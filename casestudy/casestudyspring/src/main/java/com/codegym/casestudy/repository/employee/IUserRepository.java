package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IUserRepository extends JpaRepository<User,String> {
    @Query(value = "select * from user ",nativeQuery = true)
    List<User> findAllUser();
}
