package com.example.monomod.repository.di

import com.example.monomod.domain.exchangerate.IRateRepo
import com.example.monomod.repository.exchangerate.RateRepo
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

fun provideRepository() = Kodein.Module{
    bind<IRateRepo>() with singleton { RateRepo(instance()) }
}