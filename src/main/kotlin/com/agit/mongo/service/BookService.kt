package com.agit.mongo.service

import com.agit.mongo.entity.Author
import com.agit.mongo.entity.Book
import com.agit.mongo.repository.AuthorRepository
import com.agit.mongo.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository
) {

    fun saveBook(book: Book): Book {
        return bookRepository.save(book)
    }

    fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun findBookById(id: String): Book? {
        return bookRepository.findById(id).orElse(null)
    }

    @Transactional(rollbackFor = [Exception::class])
    fun saveBookWithAuthor(book: Book, author: Author): Book {
        val savedAuthor = authorRepository.save(author)

        if (savedAuthor.name == "rollback")
            throw RuntimeException()

        book.authorId = savedAuthor.id ?: ""
        val savedBook = bookRepository.save(book)
        return savedBook
    }
}