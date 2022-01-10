package com.project.movieApi.service;

import com.project.movieApi.dto.CreateDirectorRequest;
import com.project.movieApi.dto.DirectorDto;
import com.project.movieApi.dto.UpdateDirectorRequest;
import com.project.movieApi.dto.converter.DirectorDtoConverter;
import com.project.movieApi.model.Director;
import com.project.movieApi.repository.DirectorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorDtoConverter directorDtoConverter;

    public DirectorService(DirectorRepository directorRepository, DirectorDtoConverter directorDtoConverter) {
        this.directorRepository = directorRepository;
        this.directorDtoConverter = directorDtoConverter;
    }

    public DirectorDto createDirector(DirectorDto directorDto){

        Director director= new Director(directorDto.getName(),directorDto.getLastName());
        return directorDtoConverter.convert(director);
    }

    public DirectorDto updateDirector(UpdateDirectorRequest request){

        Director getDirector = directorRepository.getById(request.getId());
        Director director = new Director(getDirector.getId(),request.getName(),request.getLastName());

        return directorDtoConverter.convert(directorRepository.save(director));
    }

    public Director getDirectorById(String id){
        return directorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bad"));
    }

    public List<DirectorDto> getAllDirector(){
        return directorRepository.findAll()
                .stream()
                .map(directorDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public void deleteDirector(String id){
         directorRepository.deleteById(id);
    }
}
