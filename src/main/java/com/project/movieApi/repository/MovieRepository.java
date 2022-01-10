package com.project.movieApi.repository;

import com.project.movieApi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,String>,CustomMovieRepository {

    Movie findByTitle(String title);

    Movie findByTitleAndDescriptionIsLike(String title,String description);

    Movie findByDurationLessThan(Integer duration);

    @Query(value = "select m.imdbUrl from Movie m where m.id=?1")
    Optional<String> selectImdbUrlByMovieId(String id);


}
