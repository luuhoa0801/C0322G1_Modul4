package com.codegym.music.repository;

import com.codegym.music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IMusicRepository extends JpaRepository<Music, Integer> {
    @Query(value = "select * from music", nativeQuery = true)
    Page<Music> findAllMusic(Pageable pageable);

    @Modifying
    @Query(value = "insert into music (name,show_man,category) values " +
            "(:name,:showMan,:category)", nativeQuery = true)
    void create(@Param("name") String name, @Param("showMan") String showMan,
                @Param("category") String category);

    @Modifying
    @Query(value = "update music set name =:name,show_man =:showMan, category = :category where id =:id")
    void update(@Param("name") String name, @Param("showMan") String showMan, @Param("category") String category,
                @Param("id") Integer id);

    @Query(value = "select * from music where id = :id", nativeQuery = true)
    Music findByIdSearch(@Param("id") Integer id);


}
