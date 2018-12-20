package com.example.monomod.network.di

import com.example.monomod.network.exchangerate.IRateWebService
import com.example.monomod.network.exchangerate.RateWebClient
import com.example.monomod.repository.exchangerate.RateClientStub
import com.example.monomod.repository.exchangerate.IRateClient
import com.github.salomonbrys.kodein.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level

fun provideStubDep() = Kodein.Module {
    bind<IRateClient>() with singleton { RateClientStub() }
}

fun provideWebDep() = Kodein.Module {

    bind<OkHttpClient>() with singleton {
        OkHttpClient.Builder()
            .addInterceptor( HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .callTimeout(60, TimeUnit.SECONDS)
            .build()

    }

    bind<Retrofit>() with provider {
        Retrofit.Builder()
            .client(instance())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(instance<String>("baseUrl"))
            .build()
    }

    bind<IRateWebService>() with provider {
        instance<Retrofit>().create(IRateWebService::class.java)
    }
    bind<IRateClient>() with provider { RateWebClient(instance())}
}