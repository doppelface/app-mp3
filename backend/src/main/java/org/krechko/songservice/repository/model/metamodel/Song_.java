package org.krechko.songservice.repository.model.metamodel;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import org.krechko.songservice.repository.model.Song;

import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Song.class)
public class Song_ {
    public static volatile SingularAttribute<Song, String> id;
    public static volatile SingularAttribute<Song, String> title;
    public static volatile SingularAttribute<Song, String> artistName;

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String ARTIST = "artist";
}
