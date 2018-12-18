package com.example.monomod.network.exchangerate

import com.example.monomod.domain.exchangerate.entity.Rate
import com.example.monomod.repository.exchangerate.IRateClient
import io.reactivex.Observable

class RateWebClient(private val rateWebService: IRateWebService) : IRateClient {

    override val rateList: Observable<List<Rate>>
        get() = rateWebService.getRates().map {
                it -> listOf(Rate(it.valute.uSD.charCode,it.valute.uSD.charCode, it.valute.uSD.value.toFloat()))
        }
}