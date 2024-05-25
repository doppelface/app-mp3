package org.krechko.songservice.service;

import org.krechko.songservice.repository.dto.SongDTO;
import org.krechko.songservice.util.SongSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {
    SongDTO saveSong(SongDTO songDTO);
    void deleteSongById(Long id);
    SongDTO getSongById(Long id);
    Page<SongDTO> getAllSongs(SongSearchCriteria searchCriteria, Pageable pageable);
}
