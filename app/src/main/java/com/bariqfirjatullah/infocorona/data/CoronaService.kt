package com.bariqfirjatullah.infocorona.data

import com.bariqfirjatullah.infocorona.*
import retrofit2.Call
import retrofit2.http.GET

interface CoronaService {
    @GET("/indonesia")
    fun getIndonesia():Call<List<IndonesiaDataItem>>
    @GET("/indonesia/provinsi")
    fun getProvinsi():Call<List<ProvinsiIndonesiaDataItem>>
    @GET("/positif")
    fun getPositif():Call<List<PositifData>>
    @GET("/meninggal")
    fun getMeninggal():Call<List<MeninggalData>>
    @GET("/sembuh")
    fun getSembuh():Call<List<SembuhData>>
}
