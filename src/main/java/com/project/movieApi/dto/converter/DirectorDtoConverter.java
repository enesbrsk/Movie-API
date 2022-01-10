package com.project.movieApi.dto.converter;


import com.project.movieApi.dto.DirectorDto;
import com.project.movieApi.dto.MovieDto;
import com.project.movieApi.model.Director;
import com.project.movieApi.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.movieApi.util.MovieDurationTimeUtil.getMovieDurationString;

@Component
public class DirectorDtoConverter {

    public DirectorDto convert(Director director){
        return new DirectorDto(director.getId(),director.getName(),
                director.getLastName(),
                getMovieList(director.getMovies().stream().collect(Collectors.toList())));
    }

    private List<MovieDto> getMovieList(List<Movie> movies) {
        return movies.stream().map(
                m->new MovieDto(
                        m.getId(),
                        m.getTitle(),
                        m.getDescription(),
                        m.getImdbUrl(),
                        getMovieDurationString(m.getDuration()),
                        m.getFeaturedYear(),
                        m.getGenresTypes()))
                .collect(Collectors.toList());
            }
}
