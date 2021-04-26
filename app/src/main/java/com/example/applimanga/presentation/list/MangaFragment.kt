package com.example.applimanga.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applimanga.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MangaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = MangaAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manga_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.manga_recycler)
        recyclerView.apply {
            layoutManager = this@MangaFragment.layoutManager
            adapter = this@MangaFragment.adapter
        }


        val mangalist = arrayListOf<Manga>().apply {
            add(Manga("Naruto"))
            add(Manga("One Piece"))
            add(Manga("FMA"))
            add(Manga("Major"))

        }

        adapter.updateList(mangalist)
    }

}