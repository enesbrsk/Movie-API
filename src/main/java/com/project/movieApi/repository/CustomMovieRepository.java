package com.project.movieApi.repository;

import java.util.Optional;

public interface CustomMovieRepository {

    Optional<String> findImdbUrlByMovieId(String Id);
}
