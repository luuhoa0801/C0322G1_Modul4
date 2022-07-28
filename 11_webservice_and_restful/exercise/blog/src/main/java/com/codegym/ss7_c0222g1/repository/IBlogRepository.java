package com.codegym.ss7_c0222g1.repository;

import com.codegym.ss7_c0222g1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog where title like :title ", nativeQuery = true)
    Page<Blog> findAllByTitle(@Param("title") String title, Pageable pageable);

    @Query(value = "select * from blog where id = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Query(value = "select * from blog where status_delete = 0", nativeQuery = true)
    List<Blog> findAll();


    @Modifying
    @Query(value = "update blog  set status_delete = 1 where id = :id ", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Modifying
    @Query(value = "update blog set title = :title, create_day = :createDay,id_category = :idCategory where id = :id",
            nativeQuery = true)
    void update(@Param("title") String title, @Param("createDay") String createDay,
                @Param("idCategory") Integer idCategory, @Param("id") Integer id);
}
