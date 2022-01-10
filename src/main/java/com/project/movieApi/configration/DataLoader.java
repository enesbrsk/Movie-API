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

        if (!movieRepository.findAll().isEmpty()) {
            return;
        }

        Actor actor1 = new Actor("Scarlett Johansson", parseDate("22-11-1984"), Gender.FEMALE);
        Actor actor2 = new Actor("Morgan Freeman", LocalDate.of(1937, 6, 1), Gender.MALE);

        Set<Actor> actors1 = actorRepository.saveAll(Arrays.asList(actor1, actor2)).stream().collect(Collectors.toSet());

        Publisher publisher1 = new Publisher("Virginie Besson-Silla");
        publisher1 = publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher("Marvel");
        publisher2 = publisherRepository.save(publisher2);

        Publisher publisher3 = new Publisher("Truenorth Productions");
        publisher3 = publisherRepository.save(publisher3);

        Director d1 = new Director("Cate", "Shortland");
        Director d2 = new Director("Malcolm","Spellman");
        List<Director> directors = directorRepository.saveAll(Arrays.asList(d1, d2));


        Movie movie1 = new Movie(
                "Lucy",
                "A woman, accidentally caught in a dark deal, turns the tables on her captors and transforms into a merciless warrior evolved beyond human logic.",
                "https://www.imdb.com/title/tt2872732/",
                89,
                2014,
                Arrays.asList(GenresType.ACTION, GenresType.SCI_FI, GenresType.THRILLER),
                actors1,
                directors.get(0),
                publisher1
        );
        movie1 = movieRepository.save(movie1);


        Movie movie2 = new Movie(
                "Black Widow",
                "Natasha Romanoff confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises.",
                "https://www.imdb.com/title/tt3480822/",
                134,
                2021,
                Arrays.asList(GenresType.ACTION, GenresType.SCI_FI, GenresType.THRILLER),
                actors1,
                directors.get(0),
                publisher2);
        movieRepository.save(movie2);


        Movie movie3 = new Movie(
                "The Falcon and the Winter Soldier",
                "Following the events of 'Avengers: Endgame,' Sam Wilson/Falcon and Bucky Barnes/Winter Soldier team up in a global adventure that tests their abilities -- and their patience.",
                "https://www.imdb.com/title/tt9208876/",
                50,
                2021,
                Arrays.asList(GenresType.ACTION, GenresType.SCI_FI, GenresType.THRILLER),
                actors1,
                directors.get(0),
                publisher3);

        movieRepository.save(movie3);
    }

    private LocalDate parseDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US);

        return LocalDate.parse(date, formatter);
    }
}