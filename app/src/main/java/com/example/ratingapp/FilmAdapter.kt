
package com.example.ratingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat


class FilmAdapter(
    context: Context?, films: List<Film>,
    private val mColorResourceId: Int
) :
    ArrayAdapter<Film?>(context!!, 0, films as List<Film?>) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                R.layout.list_item, parent, false
            )
        }

        val currentFilm: Film? = getItem(position)

        val miwokTextView = listItemView!!.findViewById<View>(R.id.miwok_text_view) as TextView

        currentFilm?.let { miwokTextView.setText(it.getName()) }

        val defaultTextView = listItemView.findViewById<View>(R.id.default_text_view) as TextView

        currentFilm?.let { defaultTextView.setText(it.getRating()) }

        val imageView = listItemView.findViewById<View>(R.id.image) as ImageView
        if (currentFilm!!.hasImage()) {

            imageView.setImageResource(currentFilm.getImageResourceId())
            imageView.visibility = View.VISIBLE
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.visibility = View.GONE
        }

        // Set the theme color for the list item
        val textContainer = listItemView.findViewById<View>(R.id.text_container)
        // Find the color that the resource ID maps to
        val color = ContextCompat.getColor(context, mColorResourceId)
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color)

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView
    }
}