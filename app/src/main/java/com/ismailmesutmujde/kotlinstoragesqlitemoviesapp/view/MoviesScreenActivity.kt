package com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.adapter.MoviesRecyclerViewAdapter
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.databinding.ActivityMoviesScreenBinding
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.model.Categories
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.model.Directors
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.model.Movies

class MoviesScreenActivity : AppCompatActivity() {

    private lateinit var bindingMoviesScreen : ActivityMoviesScreenBinding
    private lateinit var movieList:ArrayList<Movies>
    private lateinit var adapterMovies:MoviesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMoviesScreen = ActivityMoviesScreenBinding.inflate(layoutInflater)
        val view = bindingMoviesScreen.root
        setContentView(view)

        val category = intent.getSerializableExtra("categoryObject") as Categories

        bindingMoviesScreen.toolbarMovies.title = "Movies : ${category.category_name}"
        setSupportActionBar(bindingMoviesScreen.toolbarMovies)

        bindingMoviesScreen.recyclerViewMovies.setHasFixedSize(true)
        bindingMoviesScreen.recyclerViewMovies.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        movieList = ArrayList()

        val c1 = Categories(1,"Science Fiction")
        val c2 = Categories(2,"Drama")
        val c3 = Categories(3,"Action")

        val d1 = Directors(1,"Christopher Nolan")
        val d2 = Directors(2,"Quentin Tarantino")
        val d3 = Directors(3,"Roman Polanski")

        val m1 = Movies(1,"Interstellar",2014,"interstellar",c1,d1)
        val m2 = Movies(2,"Django",2012,"django",c2,d2)
        val m3 = Movies(3,"Inception",2010,"inception",c3,d1)
        val m4 = Movies(4,"The Pianist",2002,"thepianist",c2,d3)

        movieList.add(m1)
        movieList.add(m2)
        movieList.add(m3)
        movieList.add(m4)

        adapterMovies = MoviesRecyclerViewAdapter(this, movieList)
        bindingMoviesScreen.recyclerViewMovies.adapter = adapterMovies
    }
}