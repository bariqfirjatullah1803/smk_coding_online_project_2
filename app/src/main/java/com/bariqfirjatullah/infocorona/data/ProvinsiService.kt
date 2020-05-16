package com.bariqfirjatullah.infocorona.data

import com.bariqfirjatullah.infocorona.ProvinsiIndonesiaDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ProvinsiService {

    @GET("indonesia/provinsi")
    fun getProvinsi():Call<List<ProvinsiIndonesiaDataItem>>
}