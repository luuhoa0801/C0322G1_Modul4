package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {

    @Override
    public List<Music> findAll() {
        List<Music> listMusic = BaseRepository.entityManager.createQuery
                ("select m from music m where status = 0", Music.class).getResultList();
        return listMusic;
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
        Music music = BaseRepository.entityManager.createQuery
                ("select m from music m where id=?1", Music.class).setParameter(1, id).getSingleResult();
        return music;
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Music music = findById(id);
        music.setStatus(1);
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public List<Music> searchByName(String name) {
        List<Music> searchList = BaseRepository.entityManager.createQuery
                ("select m from music m where name like ?1 ", Music.class).setParameter(1, "%" + name + "%").getResultList();
        return searchList;
    }

}
