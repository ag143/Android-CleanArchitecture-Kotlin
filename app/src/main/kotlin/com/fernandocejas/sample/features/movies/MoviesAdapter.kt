package com.fernandocejas.sample.features.movies

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.fernandocejas.sample.R
import com.fernandocejas.sample.framework.extension.inflate
import kotlinx.android.synthetic.main.row_movie.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class MoviesAdapter
@Inject constructor() : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    internal var collection: List<MovieViewModel> by Delegates.observable(emptyList()) {
        property, old, new -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.row_movie))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(collection[position])

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movieViewModel: MovieViewModel?) {
            with(itemView) {
                title.text = movieViewModel?.title
            }
        }
    }
}