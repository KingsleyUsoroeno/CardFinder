package com.kingtech.cardfinder.data.network

import com.kingtech.cardfinder.data.entities.CardResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

//https://findbinnumbers.p.rapidapi.com/?bin=344567&format=json
interface CardService {

    @GET
    suspend fun getCardDetails(@Url url: String): Response<CardResult>

}