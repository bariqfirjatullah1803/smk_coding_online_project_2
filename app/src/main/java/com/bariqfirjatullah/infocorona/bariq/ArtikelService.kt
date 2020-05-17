package com.bariqfirjatullah.infocorona.bariq

import com.bariqfirjatullah.infocorona.ArtikelItem
import retrofit2.Call
import retrofit2.http.GET

interface ArtikelService {

    @GET("artikel")
    fun getArtikel():Call<List<ArtikelItem>>
}