package com.project.movieApi.dto.converter;


import com.project.movieApi.dto.ActorDto;
import com.project.movieApi.dto.DirectorDto;
import com.project.movieApi.dto.MovieDto;
import com.project.movieApi.model.Actor;
import com.project.movieApi.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.movieApi.util.MovieDurationTimeUtil.getMovieDurationString;

@Component
public class MovieDtoConverter {

    public MovieDto convert(Movie from) {
        return new MovieDto(
                from.getId(),
                from.getTitle(),
                from.getDescription(),
                from.getImdbUrl(),
                getMovieDurationString(from.getDuration()),
                from.getFeaturedYear(),
                from.getGenresTypes(),
                getActorList(from.getActors().stream().collect(Collectors.toList())),
                new DirectorDto(from.getDirector().getId(),
                        from.getDirector().getName(),
                        from.getDirector().getLastName()),
                from.getPublisher().getName()
        );
    }

    private List<ActorDto> getActorList(List<Actor> actorList) {

        return actorList.stream()
                .map(a -> new ActorDto(
                        a.getId(),
                        a.getName(),
                        a.getDateOfBirth(),
                        a.getGender()))
                .collect(Collectors.toList());
    }
}