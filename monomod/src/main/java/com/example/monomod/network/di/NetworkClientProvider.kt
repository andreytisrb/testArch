package com.example.monomod.network.di

import com.example.monomod.network.exchangerate.RateClientStub
import com.example.monomod.repository.exchangerate.IRateClient
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.factory
import com.github.salomonbrys.kodein.singleton
import retrofit2.Retrofit


fun provideStubDep() = Kodein.Module{
    bind<IRateClient>(tag = "stub") with singleton { RateClientStub() }
}

fun provideWebDep() = Kodein.Module{
    bind<IRateClient>(tag = "stub") with factory { retrofit:Retrofit -> RateClientStub() }

}