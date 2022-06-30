
package com.example.ratingapp.screens.favourite

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.ratingapp.Film
import com.example.ratingapp.FilmAdapter
import com.example.ratingapp.R

class FavouriteFragment : Fragment() {
    private var mMediaPlayer: MediaPlayer? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.word_list, container, false)


        // Create a list of words
        val films: ArrayList<Film> = ArrayList()
        films.add(
            Film(
                R.string.family_father, R.string.miwok_family_father,
                R.drawable.family_father
            )
        )
        films.add(
            Film(
                R.string.family_mother, R.string.miwok_family_mother,
                R.drawable.family_mother
            )
        )
        films.add(
            Film(
                R.string.family_son, R.string.miwok_family_son,
                R.drawable.family_son
            )
        )
        films.add(
            Film(
                R.string.family_daughter, R.string.miwok_family_daughter,
                R.drawable.family_daughter
            )
        )
        films.add(
            Film(
                R.string.family_older_brother, R.string.miwok_family_older_brother,
                R.drawable.family_older_brother
            )
        )
        films.add(
            Film(
                R.string.family_younger_brother, R.string.miwok_family_younger_brother,
                R.drawable.family_younger_brother
            )
        )
        films.add(
            Film(
                R.string.family_older_sister, R.string.miwok_family_older_sister,
                R.drawable.family_older_sister
            )
        )
        films.add(
            Film(
                R.string.family_younger_sister, R.string.miwok_family_younger_sister,
                R.drawable.family_younger_sister
            )
        )
        films.add(
            Film(
                R.string.family_grandmother, R.string.miwok_family_grandmother,
                R.drawable.family_grandmother
            )
        )
        films.add(
            Film(
                R.string.family_grandfather, R.string.miwok_family_grandfather,
                R.drawable.family_grandfather
            )
        )

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        val adapter = FilmAdapter(activity, films, R.color.category_family)

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        val listView = rootView.findViewById<View>(R.id.list) as ListView

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.adapter = adapter

        // Set a click listener to play the audio when the list item is clicked on
        listView.onItemClickListener =
            OnItemClickListener { _, _, position, _ ->

                val film: Film = films[position]

            }
        return rootView
    }


}