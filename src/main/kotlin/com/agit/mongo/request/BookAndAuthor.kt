package com.agit.mongo.request

import com.agit.mongo.entity.Author
import com.agit.mongo.entity.Book

data class BookAndAuthor(
    val book: Book,
    val author: Author
)