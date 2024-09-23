package com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context: Context)
    : SQLiteOpenHelper(context, "movies.sqlite", null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS 'directors' (\n" +
                "\t'director_id'\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t'director_name'\tTEXT\n" +
                ");")

        db?.execSQL("CREATE TABLE IF NOT EXISTS 'categories' (\n" +
                "\t'category_id'\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t'category_name'\tTEXT\n" +
                ");")
        db?.execSQL("CREATE TABLE IF NOT EXISTS 'filmler' (\n" +
                "\t'movie_id'\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t'movie_name'\tTEXT,\n" +
                "\t'movie_year'\tINTEGER,\n" +
                "\t'movie_poster'\tTEXT,\n" +
                "\t'category_id'\tINTEGER,\n" +
                "\t'director_id'\tINTEGER,\n" +
                "\tFOREIGN KEY('category_id') REFERENCES 'categories'('category_id'),\n" +
                "\tFOREIGN KEY('director_id') REFERENCES 'directors'('director_id')\n" +
                ");")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS directors")
        db?.execSQL("DROP TABLE IF EXISTS categories")
        db?.execSQL("DROP TABLE IF EXISTS movies")
        onCreate(db)
    }


}