package com.kingtech.cardfinder.data.entities


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CardResult(
    @SerializedName("result")
    val result: List<Result>
) : Serializable