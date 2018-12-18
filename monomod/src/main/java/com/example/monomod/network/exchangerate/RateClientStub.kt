package com.example.monomod.network.exchangerate

import com.example.monomod.domain.exchangerate.entity.Rate
import com.example.monomod.repository.exchangerate.IRateClient
import io.reactivex.Observable

class RateClientStub(): IRateClient {
    override val rateList: Observable<List<Rate>>
        get() = Observable.just(listOf(Rate("Ru","Ruble", 3.3f)))
}