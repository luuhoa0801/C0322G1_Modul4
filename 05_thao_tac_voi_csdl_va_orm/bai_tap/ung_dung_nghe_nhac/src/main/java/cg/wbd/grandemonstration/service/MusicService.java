package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void create(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music);
    }

    @Override
    public void delete(int id) {
        iMusicRepository.delete(id);
    }

    @Override
    public List<Music> searchByName(String name) {
        return iMusicRepository.searchByName(name);
    }
}
