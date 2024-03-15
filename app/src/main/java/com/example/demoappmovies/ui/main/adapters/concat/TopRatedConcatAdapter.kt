package com.example.demoappmovies.ui.main.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappmovies.core.BaseConcatHolder
import com.example.demoappmovies.databinding.TopRatedMoviesRowBinding
import java.lang.IllegalArgumentException

class TopRatedConcatAdapter (private val movieAdapter: MovieAdapter): RecyclerView.Adapter<BaseConcatHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding =
            TopRatedMoviesRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder) {
            is ConcatViewHolder -> holder.bind(movieAdapter)
            else -> throw IllegalArgumentException("No viewholder to show this data, did you forgot to add it to the onBindViewHolder?")
        }
    }

    //Siempre debe ser uno el tamaño del Concat porque solo es un adapter
    override fun getItemCount(): Int = 1


    private inner class ConcatViewHolder(val binding: TopRatedMoviesRowBinding): BaseConcatHolder<MovieAdapter>(binding.root){
        override fun bind(adapter: MovieAdapter) {
            binding.rvTopRatedMovies.adapter = adapter
        }

    }
}
