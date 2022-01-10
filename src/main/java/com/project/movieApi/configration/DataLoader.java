package com.project.movieApi.configration;

import com.project.movieApi.model.*;
import com.project.movieApi.repository.ActorRepository;
import com.project.movieApi.repository.DirectorRepository;
import com.project.movieApi.repository.MovieRepository;
import com.project.movieApi.repository.PublisherRepository;
import com.project.movieApi.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@ConditionalOnProperty(name = "command.line.runner.enable", havingValue = "true")
public class DataLoader implements CommandLineRunner {

    private final PublisherRepository publisherRepository;
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final MovieService movieService;

    public DataLoader(PublisherRepository publisherRepository, ActorRepository actorRepository, MovieRepository movieRepository,
                      DirectorRepository directorRepository, MovieService movieService) {
        this.publisherRepository = publisherRepository;
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
        this.movieService = movieService;
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
