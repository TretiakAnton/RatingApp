package com.example.ratingapp.model.start

data class FilmData(
    val page: Int,
    val films: List<Film>,
    val total_pages: Int,
    val total_results: Int
)