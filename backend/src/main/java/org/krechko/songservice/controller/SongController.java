package org.krechko.songservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.krechko.songservice.repository.dto.SongDTO;
import org.krechko.songservice.service.SongService;
import org.krechko.songservice.util.SongSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/song")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public SongDTO saveSong(@RequestBody @Valid SongDTO songDTO) {
       return songService.saveSong(songDTO);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<SongDTO> getSongs(
            SongSearchCriteria searchCriteria,
            Pageable pageable) {
        return songService.getAllSongs(searchCriteria, pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SongDTO getSong(@PathVariable("id") Long id) {
        return songService.getSongById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSong(@PathVariable("id") Long id) {
        songService.deleteSongById(id);
    }
}
