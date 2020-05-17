package com.bariqfirjatullah.infocorona


import com.google.gson.annotations.SerializedName

data class ArtikelItem(
    @SerializedName("content")
    val content: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("judul")
    val judul: String
)