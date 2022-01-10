package com.project.movieApi.repository

import com.project.movieApi.model.Actor
import org.springframework.data.jpa.repository.JpaRepository


interface ActorRepository : JpaRepository<Actor,String> {

    fun findAllByIdIn(idList : List<String>) : List<Actor?>?

}