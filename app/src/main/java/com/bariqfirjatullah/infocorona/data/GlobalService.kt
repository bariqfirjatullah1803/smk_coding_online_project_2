package com.bariqfirjatullah.infocorona.data

import com.bariqfirjatullah.infocorona.GlobalDataItem
import retrofit2.Call
import retrofit2.http.GET

interface GlobalService {

    @GET("/")
    fun getGlobal():Call<List<GlobalDataItem>>
}