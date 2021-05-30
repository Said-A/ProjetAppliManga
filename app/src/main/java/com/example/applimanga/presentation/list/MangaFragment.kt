package com.example.applimanga.presentation.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applimanga.R
import com.example.applimanga.presentation.api.MangaApi
import com.example.applimanga.presentation.api.MangaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MangaFragment : Fragment() {

    private val TAG = "MangaFragment"
    private lateinit var recyclerView: RecyclerView
    private val adapter = MangaAdapter(listOf(), ::OnClickedManga)

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


        val apiManga: MangaApi = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MangaApi::class.java)


        apiManga.getMangalist().enqueue(object : Callback<MangaResponse> {
            override fun onResponse(call: Call<MangaResponse>, response: Response<MangaResponse> ) {
                if (response.isSuccessful && response.body() != null) {
                    val mangaResponse: MangaResponse = response.body()!!
                    Log.e(TAG,"TAG "+ mangaResponse.top)
                    adapter.updateList(mangaResponse.top)
                }
            }

            override fun onFailure(call: Call<MangaResponse>, t: Throwable) {
                Log.e(TAG,"essaye3 " + t.message)
            }

        })




        val mangalist = arrayListOf<Manga>().apply {
            add(Manga("Naruto", "tet"))
            add(Manga("One Piece", "tetete"))

        }

        adapter.updateList(mangalist)



    }
    private fun OnClickedManga(manga: Manga) {
        findNavController().navigate(R.id.navigationtoMangaDetail)
    }

}