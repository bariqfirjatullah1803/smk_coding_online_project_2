package com.bariqfirjatullah.infocorona


import com.google.gson.annotations.SerializedName

data class PositifData(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String
)