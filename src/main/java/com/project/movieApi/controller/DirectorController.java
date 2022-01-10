package com.project.movieApi.controller;


import com.project.movieApi.dto.CreateDirectorRequest;
import com.project.movieApi.dto.DirectorDto;
import com.project.movieApi.dto.UpdateDirectorRequest;
import com.project.movieApi.model.Director;
import com.project.movieApi.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/director")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<List<DirectorDto>> getDirectors(){

        List<DirectorDto> directorDtos = directorService.getAllDirector();
        return ResponseEntity.ok(directorDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirector(@PathVariable String id){
        Director directorDto = directorService.getDirectorById(id);
        return ResponseEntity.ok(directorDto);
    }

    @PostMapping
    public ResponseEntity<DirectorDto> createDirector(DirectorDto directorDto){
        return ResponseEntity.ok(directorService.createDirector(directorDto));
    }

    @PutMapping
    public ResponseEntity<DirectorDto> updateDirector(UpdateDirectorRequest request){
        return ResponseEntity.ok(directorService.updateDirector(request));
    }

    @DeleteMapping
    public void deleteDirector(@RequestParam String id){
        deleteDirector(id);
    }
}
