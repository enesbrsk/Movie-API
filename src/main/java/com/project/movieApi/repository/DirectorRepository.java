package com.project.movieApi.repository;

import com.project.movieApi.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director,String> {
}
