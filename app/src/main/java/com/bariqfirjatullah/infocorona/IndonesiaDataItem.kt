package com.bariqfirjatullah.infocorona


import com.google.gson.annotations.SerializedName

data class IndonesiaDataItem(
    @SerializedName("meninggal")
    val meninggal: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("positif")
    val positif: String,
    @SerializedName("sembuh")
    val sembuh: String
)