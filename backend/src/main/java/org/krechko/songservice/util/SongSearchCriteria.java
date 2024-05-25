package org.krechko.songservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongSearchCriteria {
    private String title;
    private String artist;
}
