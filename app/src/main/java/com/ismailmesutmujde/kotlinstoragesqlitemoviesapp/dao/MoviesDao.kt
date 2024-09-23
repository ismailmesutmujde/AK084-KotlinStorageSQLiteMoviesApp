package com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.dao

import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.database.DatabaseHelper
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.model.Categories
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.model.Directors
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.model.Movies

class MoviesDao {
    fun allMoviesByCategoryId(dbh: DatabaseHelper, category_id:Int) : ArrayList<Movies> {
        val db = dbh.writableDatabase
        val moviesList = ArrayList<Movies>()
        val cursor = db.rawQuery("SELECT * FROM categories,directors,movies WHERE movies.category_id=categories.category_id and movies.director_id = directors.director_id and movies.category_id=$category_id", null)

        while (cursor.moveToNext()){
            val category = Categories(cursor.getInt(cursor.getColumnIndexOrThrow("category_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("category_name")))

            val director = Directors(cursor.getInt(cursor.getColumnIndexOrThrow("director_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("director_name")))

            val movie = Movies(cursor.getInt(cursor.getColumnIndexOrThrow("movie_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("movie_name")),
                cursor.getInt(cursor.getColumnIndexOrThrow("movie_year")),
                cursor.getString(cursor.getColumnIndexOrThrow("movie_poster")), category, director)

            moviesList.add(movie)
        }
        return moviesList
    }
}