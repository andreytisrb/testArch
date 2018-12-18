package com.example.monomod.domain.exchangerate

import com.example.monomod.domain.exchangerate.entity.Rate
import io.reactivex.Observable

interface IRateInteractor{
    val rateList: Observable<List<Rate>>
}


class RateInteractor (val rateRepo: IRateRepo): IRateInteractor {
    override val rateList: Observable<List<Rate>>
        get() = rateRepo.rateList

}