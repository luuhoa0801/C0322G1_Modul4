package com.codegym.music.service;

import com.codegym.music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> getAll(Pageable pageable);

    void create(Music music);

    void update(Music music);

    Music findByIdSearch(Integer id);
}
