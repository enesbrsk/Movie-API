package com.project.movieApi.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class UserReview(

        @EmbeddedId
        val userReviewId: UserReviewId,
        @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", insertable = false, updatable = false)
        val user: User,
        @ManyToOne(cascade = [CascadeType.ALL],  fetch = FetchType.LAZY)
        @JoinColumn(name = "review_id", insertable = false, updatable = false)
        val review: Review,
        val date: LocalDateTime
) {}