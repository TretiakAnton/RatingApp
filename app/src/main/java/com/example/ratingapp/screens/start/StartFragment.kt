package com.example.ratingapp.screens.start

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

class StartFragment : Fragment() {
    private var mMediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.word_list, container, false)


        val films: ArrayList<Film> = ArrayList()
        films.add(
            Film(
                R.string.number_one, R.string.miwok_number_one,
                R.drawable.number_one
            )
        )
        films.add(
            Film(
                R.string.number_two, R.string.miwok_number_two,
                R.drawable.number_two
            )
        )
        films.add(
            Film(
                R.string.number_three, R.string.miwok_number_three,
                R.drawable.number_three
            )
        )
        films.add(
            Film(
                R.string.number_four, R.string.miwok_number_four,
                R.drawable.number_four
            )
        )
        films.add(
            Film(
                R.string.number_five, R.string.miwok_number_five,
                R.drawable.number_five
            )
        )
        films.add(
            Film(
                R.string.number_six, R.string.miwok_number_six,
                R.drawable.number_six
            )
        )
        films.add(
            Film(
                R.string.number_seven, R.string.miwok_number_seven,
                R.drawable.number_seven
            )
        )
        films.add(
            Film(
                R.string.number_eight, R.string.miwok_number_eight,
                R.drawable.number_eight
            )
        )
        films.add(
            Film(
                R.string.number_nine, R.string.miwok_number_nine,
                R.drawable.number_nine
            )
        )
        films.add(
            Film(
                R.string.number_ten, R.string.miwok_number_ten,
                R.drawable.number_ten
            )
        )


        val adapter = FilmAdapter(activity, films, R.color.category_numbers)


        val listView = rootView.findViewById<View>(R.id.list) as ListView


        listView.adapter = adapter

        listView.onItemClickListener =
            OnItemClickListener { _, _, position, _ ->

                val film: Film = films[position]

            }
        return rootView
    }

    override fun onStop() {
        super.onStop()

        releaseMediaPlayer()
    }


    private fun releaseMediaPlayer() {
        if (mMediaPlayer != null) {

            mMediaPlayer!!.release()

            mMediaPlayer = null
        }
    }
}