package com.bariqfirjatullah.infocorona.bariq

import com.bariqfirjatullah.infocorona.BiodataItem
import retrofit2.Call
import retrofit2.http.GET

interface BiodataService {

    @GET("biodata")
    fun getBiodata():Call<List<BiodataItem>>
}