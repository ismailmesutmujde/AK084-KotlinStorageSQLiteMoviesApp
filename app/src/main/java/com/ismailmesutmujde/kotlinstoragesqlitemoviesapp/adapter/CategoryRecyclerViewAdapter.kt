package com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.R
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.model.Categories
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.view.MoviesScreenActivity

class CategoryRecyclerViewAdapter (private val mContext: Context, private val categoryList:List<Categories>)
    : RecyclerView.Adapter<CategoryRecyclerViewAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(view: View) : RecyclerView.ViewHolder(view) {
        var category_card: CardView
        var textViewCategoryName: TextView

        init {
            category_card = view.findViewById(R.id.category_card)
            textViewCategoryName = view.findViewById(R.id.textViewCategoryName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.category_card_design, parent, false)
        return CardDesignHolder(design)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val category = categoryList.get(position)
        holder.textViewCategoryName.text = category.category_name

        holder.category_card.setOnClickListener {
            val intent = Intent(mContext, MoviesScreenActivity::class.java)
            intent.putExtra("categoryObject", category)
            mContext.startActivity(intent)
        }
    }
}