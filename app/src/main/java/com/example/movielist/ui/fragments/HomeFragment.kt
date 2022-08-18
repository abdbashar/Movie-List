package com.example.movielist.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.data.model.MovieData
import com.example.movielist.data.model.MovieResponse
import com.example.movielist.data.repository.MovieRepository
import com.example.movielist.data.request.State
import com.example.movielist.databinding.FragmentHomeBinding
import com.example.movielist.ui.`interface`.OnClickListener
import com.example.movielist.ui.adapter.RecyclerAdapter
import com.example.movielist.util.navigateTo
import kotlinx.coroutines.async
import java.util.ArrayList


class HomeFragment : BaseFragment<FragmentHomeBinding>(), OnClickListener {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
            = FragmentHomeBinding::inflate

    override fun setup() {
        createRequest()
      }

    private fun createRequest() {
        lifecycleScope.async {
            MovieRepository().getPopularMovies().collect { state ->
                ResponseState(state)
            }
        }
     }

    private fun ResponseState(state: State<MovieResponse>) = when (state) {
        is State.Loading -> {
         }
        is State.Failure -> {
            Toast.makeText(requireActivity(), "Oops there are something wrong.",
                Toast.LENGTH_SHORT
            )
                .show()
        }
        is State.Success -> state.data.movies.let {
            stopLoading()
            setupRecyclerview(it)
        }
    }

    private fun setupRecyclerview(movieData: List<MovieData>) {

        binding.rvMoviesList.visibility = View.VISIBLE
        binding.rvMoviesList.layoutManager = LinearLayoutManager(
            requireContext(),LinearLayoutManager.VERTICAL,false
        )
        binding.rvMoviesList.adapter = RecyclerAdapter(movieData, this)

    }

    private fun stopLoading() {
       binding.progressbar.visibility = View.GONE

     }


    override fun onClick(item: MovieData) {
        val data = Bundle()
        data.putParcelable("MoviesData", item)
        requireActivity().navigateTo(MovieDetailsFragment(),data)
    }

}
//    fun getPopularMovies(){
//        movieRepository = MovieRepository(movieApi)
//    }



