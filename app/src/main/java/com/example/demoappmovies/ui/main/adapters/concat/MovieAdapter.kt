package com.example.demoappmovies.ui.main.adapters.concat


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoappmovies.core.BaseViewHolder
import com.example.demoappmovies.data.model.Movie
import com.example.demoappmovies.databinding.MovieItemBinding

//El adapter se necesita inicializar con uan lista de películas, porque esa lista se pondrá en esa
// recyclerView y se inicializa con la interfaz que se creo aca.
class MovieAdapter(
    //Lista de películas
    private val moviesList: List<Movie>,
    //Se crea una variable que se asigna como la interfaz
    private val itemClickListener: OnMovieClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {

    //En concreto  es la interfaz que agarra el click
    interface OnMovieClickListener{
        fun onMovieClick(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MoviesViewHolder(itemBinding, parent.context)

        //En concreto se obtiene el click de cada elemento
        //Se obtiene la posición de cada elemento que clickemos en lista
        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION}
                ?: return@setOnClickListener
            //una vez obtenida la posición del elemento, se usa la interfaz y ya se puede acceder al
            // método de la interfaz que es onMovieClick y con moviesList se accede a la película
            // cuando se le da click y se le asigna ese método a la interfaz.
            itemClickListener.onMovieClick(moviesList[position])
        }
        return holder

    }

    //En concreto esto dibuja cada elemento en pantalla
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        //A cada elemento se le asgine una película. BindViewHolder nos da la position y así se bindea cada una de los elementos,
        when(holder){
            is MoviesViewHolder -> holder.bind(moviesList[position])
        }
    }

    //En concreto muestra la cantidad de elementos que tiene la lista
    override fun getItemCount(): Int = moviesList.size

    //En concreto se encarga de poner la imagen a cada elemento.
    private inner class MoviesViewHolder(
        val binding: MovieItemBinding,
        val context: Context
    ):BaseViewHolder<Movie>(binding.root){
        override fun bind(item: Movie){
            Glide.with(context).load("https://image.tmdb.org/t/p/w500/${item.poster_path}").centerCrop().into(binding.imgMovie)
        }
    }


}