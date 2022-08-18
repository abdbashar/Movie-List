package com.example.movielist.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.movielist.data.model.MovieData
import com.example.movielist.databinding.FragmentMovieDetailsBinding
import com.example.movielist.ui.fragments.BaseFragment
import com.example.movielist.util.Constant

class MovieDetailsFragment :  BaseFragment<FragmentMovieDetailsBinding>(){
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) ->
    FragmentMovieDetailsBinding get() = FragmentMovieDetailsBinding::inflate

    private lateinit var movieData: MovieData
    override fun setup() {
        movieData = arguments?.getParcelable("MoviesData")!!

        setData()
     }

    private fun setData() {
        Glide.with(requireActivity())
            .load("${Constant.IMAGE_BASE_URL}${movieData.posterPath}")
            .into(binding.posterImage)
        binding.apply {
            movieTitle.text = movieData.title
            IMDBRating.text = movieData.imDbRating
            movieReleaseDate.text = movieData.year
            Overview.text = movieData.description
        }
     }


}