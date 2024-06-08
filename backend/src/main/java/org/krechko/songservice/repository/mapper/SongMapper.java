package org.krechko.songservice.repository.mapper;

import org.krechko.songservice.repository.dto.SongDTO;
import org.krechko.songservice.repository.model.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SongMapper {
    @Mapping(target = "id", source = "song.id")
    @Mapping(target = "title", source = "song.title")
    @Mapping(target = "artist", source = "song.artist")
    SongDTO songToSongDTO(Song song);
    @Mapping(target = "id", source = "songDTO.id")
    @Mapping(target = "title", source = "songDTO.title")
    @Mapping(target = "artist", source = "songDTO.artist")
    Song songDtoToSong(SongDTO songDTO);


}
