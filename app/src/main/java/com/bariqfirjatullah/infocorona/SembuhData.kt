package com.bariqfirjatullah.infocorona


import com.google.gson.annotations.SerializedName

data class SembuhData(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String
)