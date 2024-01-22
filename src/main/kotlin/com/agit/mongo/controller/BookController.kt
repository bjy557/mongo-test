package com.agit.mongo.controller

import com.agit.mongo.entity.Book
import com.agit.mongo.request.BookAndAuthor
import com.agit.mongo.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController(private val bookService: BookService) {

    @PostMapping
    fun saveBook(@RequestBody book: Book): ResponseEntity<Book> {
        val savedBook = bookService.saveBook(book)
        return ResponseEntity(savedBook, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllBooks(): ResponseEntity<List<Book>> {
        val books = bookService.getAllBooks()
        return ResponseEntity(books, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: String): ResponseEntity<Book> {
        val book = bookService.findBookById(id)
        return if (book != null) {
            ResponseEntity(book, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/with_author")
    fun saveWithAuthor(@RequestBody req: BookAndAuthor): ResponseEntity<Book> {
        val book = req.book
        val author = req.author
        val savedBook = bookService.saveBookWithAuthor(book, author)
        return ResponseEntity(savedBook, HttpStatus.OK)
    }
}