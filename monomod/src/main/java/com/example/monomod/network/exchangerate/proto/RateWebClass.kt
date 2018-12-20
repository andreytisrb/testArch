package com.example.monomod.network.exchangerate.proto

import com.example.monomod.network.exchangerate.proto.Valute
import com.google.gson.annotations.SerializedName

data class RateWebClass(
    @SerializedName("Date")
    val date: String,
    @SerializedName("PreviousDate")
    val previousDate: String,
    @SerializedName("PreviousURL")
    val previousURL: String,
    @SerializedName("Timestamp")
    val timestamp: String,
    @SerializedName("Valute")
    val valute: Valute
)
