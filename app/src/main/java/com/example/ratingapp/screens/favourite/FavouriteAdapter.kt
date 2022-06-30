package com.example.ratingapp.screens.favourite

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ratingapp.R
import com.example.ratingapp.model.start.Film
import kotlinx.android.synthetic.main.item_film_layout.view.*

class FavouriteAdapter : RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {

    private var favouriteList = emptyList<Film>()

    class FavouriteViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_film_layout, parent, false)
        return FavouriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.itemView.item_name.text = favouriteList[position].title
        holder.itemView.item_rating.text = favouriteList[position].vote_average.toString()
        holder.itemView.item_description.text = favouriteList[position].overview
        val image: Bitmap = getBitmap(favouriteList[position].poster_path)
        holder.itemView.item_image.setImageBitmap(image)

    }

    override fun getItemCount(): Int {
        return favouriteList.size
    }


    private fun getBitmap(posterPath: String): Bitmap {
        val urlString = "https://image.tmdb.org/t/p/w500"
        val url = urlString + posterPath
        val image: Bitmap?
        val `in` = java.net.URL(url).openStream()
        image = BitmapFactory.decodeStream(`in`)
        return image
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Film>) {
        favouriteList = list
        notifyDataSetChanged()
    }

}



