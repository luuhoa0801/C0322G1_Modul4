package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where title like :title and status_delete = 0",
            nativeQuery = true)
    Page<Blog> findAllByTitle(@Param("title") String title, Pageable pageable);

    @Query(value = "select * from blog where id = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Query(value = "select * from blog where status_delete = 0", nativeQuery = true)
    Page<Blog> findAllBlog(Pageable pageable);

    @Modifying
    @Query(value = "insert into blog (title,create_day,id_category) values " +
            "(:title,:createDay,:id_category)", nativeQuery = true)
    void create(@Param("title") String title,
                @Param("createDay") String createDay,
                @Param("id_category") Integer id_category);

    @Modifying
    @Query(value = "update blog  set status_delete = 1 where id = :id ", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Modifying
    @Query(value = "update blog set title = :title, create_day = :createDay,id_category = :idCategory where id = :id",
            nativeQuery = true)
    void update(@Param("title") String title, @Param("createDay") String createDay,
                @Param("idCategory") Integer idCategory, @Param("id") Integer id);

}
