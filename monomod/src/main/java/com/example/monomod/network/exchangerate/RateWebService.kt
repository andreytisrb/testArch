package com.example.monomod.network.exchangerate

import com.example.monomod.network.exchangerate.proto.RateWebClass
import io.reactivex.Observable
import okhttp3.Response
import retrofit2.http.GET


interface IRateWebService {
    @GET("daily_json.js")
    fun getRates(): Observable<RateWebClass>
}


