package org.krechko.songservice.repository.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
    private Long id;

    @NotBlank(message = "Title can't be blank")
    @Size(min = 1, max = 50, message = "Title must be between 1 and 50 characters")
    private String title;

    @NotBlank(message = "Name can't be blank")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String artist;
}
