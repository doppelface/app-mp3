package org.krechko.songservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.krechko.songservice.exception.SongNotFoundException;
import org.krechko.songservice.repository.SongRepository;
import org.krechko.songservice.repository.dto.SongDTO;
import org.krechko.songservice.repository.mapper.SongMapper;
import org.krechko.songservice.repository.model.Song;
import org.krechko.songservice.service.SongService;
import org.krechko.songservice.util.SongSearchCriteria;
import org.krechko.songservice.util.SongSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongMapper songMapper;
    private final SongRepository songRepository;
    @Override
    public SongDTO saveSong(SongDTO songDTO) {
        var savedSong = songRepository
                .save(songMapper.songDtoToSong(songDTO));
        return songMapper.songToSongDTO(savedSong);
    }

    @Override
    public void deleteSongById(Long id) {
        songRepository.deleteById(ifSongExists(id).getId());
    }

    @Override
    public SongDTO getSongById(Long id) {
        return songMapper.songToSongDTO(ifSongExists(id));
    }
    @Override
    public Page<SongDTO> getAllSongs(SongSearchCriteria searchCriteria, Pageable pageable) {
        SongSpecification specification = new SongSpecification(searchCriteria);
        Page<Song> songs = songRepository.findAll(specification, pageable);
        return songs.map(songMapper::songToSongDTO);
    }

    public Song ifSongExists(Long id) {
        return songRepository
                .findById(id)
                .orElseThrow(() -> new SongNotFoundException("Song with id: " +id + " not found"));
    }
}
