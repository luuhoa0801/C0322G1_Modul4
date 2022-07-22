package com.codegym.music.service;

import com.codegym.music.model.Music;
import com.codegym.music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public Page<Music> getAll(Pageable pageable) {
        return iMusicRepository.findAllMusic(pageable);
    }

    @Override
    public void create(Music music) {
        iMusicRepository.create(music.getName(), music.getShowMan(), music.getCategory());
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music.getName(), music.getShowMan(), music.getCategory(), music.getId());
    }

    @Override
    public Music findByIdSearch(Integer id) {
        return iMusicRepository.findByIdSearch(id);
    }
}
