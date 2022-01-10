package com.project.movieApi.service;

import com.project.movieApi.dto.CreateMovieRequest;
import com.project.movieApi.dto.MovieDto;
import com.project.movieApi.dto.converter.MovieDtoConverter;
import com.project.movieApi.exception.MovieNotFoundException;
import com.project.movieApi.model.Actor;
import com.project.movieApi.model.Director;
import com.project.movieApi.model.Movie;
import com.project.movieApi.model.Publisher;
import com.project.movieApi.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(MovieService.class);

    private final MovieRepository movieRepository;
    private final ActorService actorService;
    private final PublisherService publisherService;
    private final DirectorService directorService;
    private final MovieDtoConverter movieDtoConverter;


    public MovieService(MovieRepository movieRepository,
                        ActorService actorService,
                        PublisherService publisherService,
                        DirectorService directorService, MovieDtoConverter movieDtoConverter) { //Memory address
        this.movieRepository = movieRepository;
        this.actorService = actorService;
        this.publisherService = publisherService;
        this.directorService = directorService;
        this.movieDtoConverter = movieDtoConverter;
    }

    public MovieDto createMovie(CreateMovieRequest createMovieRequest){

        Publisher publisher = publisherService.getPublisherById(createMovieRequest.getPublisherId());
        Director director = directorService.getDirectorById(createMovieRequest.getDirectorId());
        Set<Actor> actorList = actorService.getActorList(createMovieRequest.getActorIds()).stream().collect(Collectors.toSet());

        logger.info("Publisher, director and actorList received");
        Movie movie = new Movie(
                createMovieRequest.getTitle(),
                createMovieRequest.getDescription(),
                createMovieRequest.getImdbUrl(),
                createMovieRequest.getDuration(),
                createMovieRequest.getFeaturedYear(),
                createMovieRequest.getGenresType(),
                actorList,
                director,
                publisher);

        return movieDtoConverter.convert(movieRepository.save(movie));
    }

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll()
                .stream().map(movieDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public String findImdbUrlById(String id) {
        return movieRepository.selectImdbUrlByMovieId(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie could not find by id: " + id));
    }

    public MovieDto getMovieById(String id) {
        return movieDtoConverter.convert(findMovieById(id));
    }

    protected Movie findMovieById(String id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie could not find by id: " + id));
    }
}