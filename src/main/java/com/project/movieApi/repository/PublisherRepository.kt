package com.project.movieApi.repository

import com.project.movieApi.model.Publisher
import org.springframework.data.jpa.repository.JpaRepository

interface PublisherRepository : JpaRepository<Publisher,String>{

}