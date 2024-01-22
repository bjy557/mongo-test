package com.agit.mongo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "authors")
data class Author(
    @Id
    val id: String? = null,
    val name: String
)