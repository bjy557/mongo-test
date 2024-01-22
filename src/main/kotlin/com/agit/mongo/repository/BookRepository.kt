package com.agit.mongo.repository

import com.agit.mongo.entity.Book
import org.springframework.data.mongodb.repository.MongoRepository

interface BookRepository: MongoRepository<Book, String>