package com.example.monomod.network.exchangerate

import io.reactivex.Observable
import retrofit2.http.GET


interface IRateWebService {
    @GET()
    fun getRates(): Observable<RateWebClass>
}


