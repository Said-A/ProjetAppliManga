package com.example.applimanga.presentation.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.applimanga.R
import com.example.applimanga.presentation.Singletons
import com.example.applimanga.presentation.api.MangaDetailResponse
import com.example.applimanga.presentation.api.MangaResponse
import com.example.applimanga.presentation.list.Manga
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MangaDetailFragement : Fragment() {

    private lateinit var textViewStatus:TextView
    private  lateinit var textViewScore: TextView
    private  lateinit var textViewSynopsis: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragement_manga_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewStatus= view.findViewById(R.id.manga_detail)
        textViewScore = view.findViewById(R.id.manga_score)
        textViewSynopsis = view.findViewById(R.id.manga_synopsis)
        callApi()
        }

    private fun callApi() {
        val id = arguments?.getInt("mangaId") ?: -1
        Singletons.apiManga.getMangaDetailList(id).enqueue(object : Callback<MangaDetailResponse> {
            override fun onResponse(call: Call<MangaDetailResponse>, response: Response<MangaDetailResponse>) {
               Log.e("tet","ca marche")
                if (response.isSuccessful && response.body() != null) {
                    textViewStatus.text = response.body()!!.status
                    textViewScore.text = response.body()!!.score.toString()
                    textViewSynopsis.text = response.body()!!.synopsis

                }
            }

            override fun onFailure(call: Call<MangaDetailResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}