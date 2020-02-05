package com.kingtech.cardfinder.data.repository

import com.kingtech.cardfinder.data.network.CardService

class CardServiceRepository(private val cardService: CardService) {

    suspend fun getCardDetails(url: String) =
        cardService.getCardDetails(url)
}