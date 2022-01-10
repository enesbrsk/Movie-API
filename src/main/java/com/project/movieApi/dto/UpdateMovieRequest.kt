package com.project.movieApi.dto

import com.project.movieApi.model.GenresType

class UpdateMovieRequest @JvmOverloads constructor(
    description: String?,
    imdbUrl: String?,
    duration: Int?,
    featuredYear: Int?,
    genresType: List<GenresType>?,
    actorIds: List<String>?,
    publisherId: String?,
    directorId: String?
) : BaseMovieRequest(description, imdbUrl, duration, featuredYear, genresType, actorIds, publisherId, directorId)