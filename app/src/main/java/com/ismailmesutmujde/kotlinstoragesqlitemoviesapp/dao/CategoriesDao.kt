package com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.dao

import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.database.DatabaseHelper
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.model.Categories

class CategoriesDao {
    fun allCategories(dbh:DatabaseHelper) : ArrayList<Categories> {
        val db = dbh.writableDatabase
        val categoriesList = ArrayList<Categories>()
        val cursor = db.rawQuery("SELECT * FROM categories", null)

        while (cursor.moveToNext()){
            val category = Categories(cursor.getInt(cursor.getColumnIndexOrThrow("category_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("category_name")))
            categoriesList.add(category)
        }
        return categoriesList
    }
}