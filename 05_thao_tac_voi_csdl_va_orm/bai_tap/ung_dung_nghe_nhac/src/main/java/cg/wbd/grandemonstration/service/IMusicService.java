package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void create(Music music);

    Music findById(int id);

    void update(Music music);

    void delete(int id);

    List<Music> searchByName(String name);
}
