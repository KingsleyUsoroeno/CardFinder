package com.kingtech.cardfinder.data.entities


import com.google.gson.annotations.SerializedName

data class Bin(
    @SerializedName("ADI")
    val aDI: String,
    @SerializedName("BIN")
    val bIN: String,
    @SerializedName("Bank")
    val bank: String,
    @SerializedName("Brand")
    val brand: String,
    @SerializedName("CardCategory")
    val cardCategory: String,
    @SerializedName("CardType")
    val cardType: String,
    @SerializedName("CountryCode")
    val countryCode: String,
    @SerializedName("CountryName")
    val countryName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("Latitude")
    val latitude: String,
    @SerializedName("Location")
    val location: String,
    @SerializedName("Longitude")
    val longitude: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("SubBrand")
    val subBrand: String,
    @SerializedName("Type")
    val type: String
)