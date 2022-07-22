package com.codegym.form_user.repository;

import com.codegym.form_user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user", nativeQuery = true)
    Page<User> findAllUser(Pageable pageable);

    @Modifying
    @Query(value = "insert into user (first_name,last_name,phone,age,email) values " +
            "(:firstName,:lastName,:phone,:age,:email)", nativeQuery = true)
    void create(@Param("firstName") String firstName, @Param("lastName") String lastName,
                @Param("phone") String phone, @Param("age") Integer age, @Param("email") String email);

}
