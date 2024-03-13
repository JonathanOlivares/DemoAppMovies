package com.example.demoappmovies.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappmovies.core.BaseConcatHolder
import com.example.demoappmovies.core.BaseViewHolder
import com.example.demoappmovies.databinding.MovieItemBinding
import com.example.demoappmovies.databinding.PopularMoviesRowBinding

//MovieAdapter es el que le vamos a pasar a ConcatAdapter
class PopularConcatAdapter(private val movieAdapter: MovieAdapter): RecyclerView.Adapter<BaseConcatHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding =PopularMoviesRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder) {
            is ConcatViewHolder -> holder.bind(movieAdapter)
        }
    }

    //Siempre debe ser uno el tamaño del Concat porque solo es un adapter
    override fun getItemCount(): Int = 1


    private inner class ConcatViewHolder(val binding: PopularMoviesRowBinding): BaseConcatHolder<MovieAdapter>(binding.root){
        override fun bind(adapter: MovieAdapter) {
            binding.rvPopularMovies.adapter = adapter
        }

    }
}

