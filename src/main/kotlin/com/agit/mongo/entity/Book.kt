package com.agit.mongo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "books")
data class Book(
    @Id
    val id: String? = null,
    val title: String,
    var authorId: String? = null
)