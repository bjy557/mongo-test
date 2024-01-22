package com.agit.mongo.repository

import com.agit.mongo.entity.Author
import org.springframework.data.mongodb.repository.MongoRepository

interface AuthorRepository : MongoRepository<Author, String>