package com.bariqfirjatullah.infocorona.data

import com.bariqfirjatullah.infocorona.IndonesiaDataItem
import retrofit2.Call
import retrofit2.http.GET

interface CoronaService {
    @GET("indonesia")
    fun getIndonesia():Call<List<IndonesiaDataItem>>
}
