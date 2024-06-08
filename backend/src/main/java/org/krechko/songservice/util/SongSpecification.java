package org.krechko.songservice.util;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.krechko.songservice.repository.model.Song;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static org.krechko.songservice.repository.model.metamodel.Song_.ARTIST;
import static org.krechko.songservice.repository.model.metamodel.Song_.TITLE;

@RequiredArgsConstructor
public class SongSpecification implements Specification<Song> {

    private final SongSearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Song> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (searchCriteria.getTitle() != null && !searchCriteria.getTitle().isBlank()) {
            predicates.add(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get(TITLE)),
                    "%" + searchCriteria.getTitle().toLowerCase() + "%"));
        }

        if (searchCriteria.getArtist() != null && !searchCriteria.getArtist().isBlank()) {
            predicates.add(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get(ARTIST)),
                    "%" + searchCriteria.getArtist().toLowerCase() + "%"));
        }

        return criteriaBuilder.and(predicates.toArray(Predicate[]::new));

    }
}
