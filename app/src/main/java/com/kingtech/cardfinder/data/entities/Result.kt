package com.kingtech.cardfinder.data.entities


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("bin")
    val bin: Bin
)