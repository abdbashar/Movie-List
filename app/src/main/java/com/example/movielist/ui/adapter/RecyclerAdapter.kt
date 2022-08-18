package com.example.movielist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielist.R
import com.example.movielist.data.model.MovieData
import com.example.movielist.databinding.MovieItemBinding
import com.example.movielist.ui.`interface`.OnClickListener
import com.example.movielist.util.Constant
import java.util.ArrayList

class RecyclerAdapter(
    private var movieData: List<MovieData>,
    private var listener: OnClickListener
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            if(movieData.elementAt(position).title?.length ?: 0 > 20) {
                movieTitle.text = (movieData.elementAt(position).title?.take(20) ?: "") + "..."
            }
            else{
                movieTitle.text = movieData.elementAt(position).title
            }
            IMDBRating.text = "Rating :" + movieData.elementAt(position).imDbRating
            movieReleaseDate.text = movieData.elementAt(position).year
            Glide.with(holder.itemView)
                .load("${Constant.IMAGE_BASE_URL}${movieData.elementAt(position).posterPath}")
                .placeholder(R.drawable.grey_man)
                .into(moviePoster)
            holder.itemView.setOnClickListener { listener.onClick(movieData[position]) }

        }

    }

}
