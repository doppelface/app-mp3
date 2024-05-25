package org.krechko.songservice.repository;


import org.krechko.songservice.repository.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface SongRepository extends JpaRepository<Song, Long>, JpaSpecificationExecutor<Song> {

}
