package com.example.monomod.domain.exchangerate

import com.example.monomod.domain.exchangerate.entity.Rate
import io.reactivex.Observable

interface IRateRepo {
    val rateList: Observable<List<Rate>>
}