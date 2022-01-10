package com.project.movieApi.service;

import com.project.movieApi.exception.PublisherNotFoundException;
import com.project.movieApi.model.Publisher;
import com.project.movieApi.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class PublisherService {

    private static final Logger logger = LoggerFactory.getLogger(PublisherService.class);

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    protected Publisher getPublisherById(String id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Publisher not found with id " + id);
                    return new PublisherNotFoundException("Publisher not found id: " + id );
                });
    }

}
