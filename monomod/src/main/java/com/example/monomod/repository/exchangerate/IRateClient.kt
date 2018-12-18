package com.example.monomod.repository.exchangerate

import com.example.monomod.domain.exchangerate.entity.Rate
import io.reactivex.Observable

interface IRateClient {
    val rateList: Observable<List<Rate>>
}