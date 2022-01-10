package com.project.movieApi.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.project.movieApi.model.Gender
import com.project.movieApi.model.Movie
import org.springframework.hateoas.RepresentationModel
import java.time.LocalDate


data class ActorDto @JvmOverloads constructor(
    val id: String,
    val name: String,
    val dateOfBirth: LocalDate,
    val gender: Gender,
    @JsonInclude(JsonInclude.Include.NON_EMPTY) //movie listesi bos ise Json'da gosterme
    val movieList: List<MovieDto>? = ArrayList()

) : RepresentationModel<ActorDto>()