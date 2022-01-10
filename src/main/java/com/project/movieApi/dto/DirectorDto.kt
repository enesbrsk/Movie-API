package com.project.movieApi.dto

data class DirectorDto @JvmOverloads constructor(
    val id: String,
    val name: String,
    val lastName: String,
    val movieList: List<MovieDto>? = ArrayList()

){

}