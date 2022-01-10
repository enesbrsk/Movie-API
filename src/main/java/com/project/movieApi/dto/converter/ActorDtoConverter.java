package com.project.movieApi.dto.converter;

import com.project.movieApi.dto.ActorDto;
import com.project.movieApi.dto.MovieDto;
import com.project.movieApi.model.Actor;
import com.project.movieApi.model.Movie;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import static com.project.movieApi.util.MovieDurationTimeUtil.getMovieDurationString;

@Component
public class ActorDtoConverter {

    public ActorDto convert(Actor actor){
        return new ActorDto(actor.getId(),actor.getName(),
                actor.getDateOfBirth(),actor.getGender(),
                getMovieList(actor.getMovies().stream().collect(Collectors.toList())));
    }

    private List<MovieDto> getMovieList(List<Movie> movies) {
        return movies.stream()
                .map(m -> new MovieDto(
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
