package com.example.ratingapp
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class FilmRepo {
     val url : String = "https://api.themoviedb.org/3/movie/550?api_key=61c2e50d8717707bf5d6e4c6222e643e"

     suspend fun getFilms() = coroutineScope {
         launch {
            var text :String
            val connection = URL(url[0].toString()).openConnection() as HttpURLConnection
             try {
                 connection.connect()
                 text = connection.inputStream.use { it.reader().use {reader -> reader.readText()  } }
             }finally {
                 connection.disconnect()
             }
             return@launch
         }
     }

}
