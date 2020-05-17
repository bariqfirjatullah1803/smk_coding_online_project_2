package com.bariqfirjatullah.infocorona


import com.google.gson.annotations.SerializedName

data class BiodataItem(
    @SerializedName("alamat")
    val alamat: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("jk")
    val jk: String,
    @SerializedName("nama")
    val nama: String,
    @SerializedName("telp")
    val telp: String,
    @SerializedName("umur")
    val umur: String
)