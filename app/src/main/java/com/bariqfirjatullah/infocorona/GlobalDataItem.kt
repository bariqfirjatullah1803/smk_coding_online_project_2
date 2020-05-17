package com.bariqfirjatullah.infocorona


import com.google.gson.annotations.SerializedName

data class GlobalDataItem(
    @SerializedName("attributes")
    val attributes: AttributesX
)