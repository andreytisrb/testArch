package com.example.monomod.repository.exchangerate

import com.example.monomod.domain.exchangerate.IRateRepo
import com.example.monomod.domain.exchangerate.entity.Rate
import com.example.monomod.repository.exchangerate.IRateClient
import io.reactivex.Observable

class RateRepo(private val rateClient: IRateClient): IRateRepo {
    override val rateList: Observable<List<Rate>>
        get() = rateClient.rateList
}