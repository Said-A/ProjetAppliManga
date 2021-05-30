package com.example.applimanga.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applimanga.R

class MangaAdapter(private var dataSet: List<Manga>, val listener: ((Manga) -> Unit)? = null) :
    RecyclerView.Adapter<MangaAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.nom_manga)
            imageView =view.findViewById(R.id.img_manga)
            textView.setOnClickListener {

            }
        }
    }

    fun updateList(list: List<Manga>){
        dataSet = list
        notifyDataSetChanged()
    }



    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_manga, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val manga:Manga = dataSet[position]
        viewHolder.textView.text = manga.title
        viewHolder.imageView.setOnClickListener {
            listener?.invoke(manga)
        }

        Glide
                .with(viewHolder.itemView.context)
                .load(manga.image_url)
                .centerCrop()
                .into(viewHolder.imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
