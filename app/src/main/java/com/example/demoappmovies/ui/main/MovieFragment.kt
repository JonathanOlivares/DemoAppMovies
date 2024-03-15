package com.example.demoappmovies.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.demoappmovies.R
import com.example.demoappmovies.core.Resource
import com.example.demoappmovies.data.local.AppDatabase
import com.example.demoappmovies.data.local.LocalMovieDataSource
import com.example.demoappmovies.data.model.Movie
import com.example.demoappmovies.data.remote.RemoteMovieDataSource
import com.example.demoappmovies.databinding.FragmentMovieBinding
import com.example.demoappmovies.presentation.MovieViewModel
import com.example.demoappmovies.presentation.MovieViewModelFactory
import com.example.demoappmovies.domain.MovieRepositoryImpl
import com.example.demoappmovies.domain.RetrofitClient
import com.example.demoappmovies.ui.main.adapters.concat.MovieAdapter
import com.example.demoappmovies.ui.main.adapters.concat.PopularConcatAdapter
import com.example.demoappmovies.ui.main.adapters.concat.TopRatedConcatAdapter
import com.example.demoappmovies.ui.main.adapters.concat.UpcomingConcatAdapter


class MovieFragment : Fragment(R.layout.fragment_movie), MovieAdapter.OnMovieClickListener{

    //Para hacer el Set Up del ConcatAdapter, se genera la instancia del ConcatAdapter
    private lateinit var  concatAdapter: ConcatAdapter
    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(
            MovieRepositoryImpl(
                RemoteMovieDataSource(RetrofitClient.webservice),
                LocalMovieDataSource(AppDatabase.getDatabase(requireContext()).movieDao())
                //requireContext se utiliza porque estamos dentro de un fragmento.
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        //Despues inicializamos el concatadapter, esto me va a generar una instancia vacia, se tiene
        // que hacer es decidir en que orden se van a mostrar las distinas secciones y cada una de
        // sa secciones se le tiene que pasar una lista de datos(lista de películas.
        // Entonces se modificará el viewModel de abajo para hacer eso.
        concatAdapter = ConcatAdapter()

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, Observer{ result ->
            when(result){
                is Resource.Loading ->{
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("LiveData","Loading...")
                }
                is Resource.Success ->{
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(0,UpcomingConcatAdapter(MovieAdapter(result.data.first.results, this@MovieFragment)))
                        addAdapter(1,PopularConcatAdapter(MovieAdapter(result.data.second.results, this@MovieFragment)))
                        addAdapter(2,TopRatedConcatAdapter(MovieAdapter(result.data.third.results, this@MovieFragment)))

                    }
                    //binding del adapter en el RecyclerView principal.
                    binding.rvMovies.adapter = concatAdapter
                    Log.d("LiveData", "Upcoming ${result.data.first} \n \nPopular: ${result.data.second} \n \nTopRated:${result.data.third}")
                }
                is Resource.Failure ->{
                    binding.progressBar.visibility = View.GONE
                    Log.d("Error","${result.exception}")
                    Toast.makeText(requireContext(),"Error: ${result.exception}",Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    //Se implementa la interfaz que se creo en movieadapter ya que nos lo pide el itemclicklistene y
    // se habilita el boton de cada película
    override fun onMovieClick(movie: Movie) {
        val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(
            movie.poster_path,
            movie.backdrop_path,
            movie.vote_average.toFloat(),
            movie.vote_count,
            movie.overview,
            movie.title,
            movie.original_language,
            movie.release_date
            )
        findNavController().navigate(action)
    }
}