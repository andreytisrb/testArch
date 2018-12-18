package com.example.monomod.domain.di

import com.example.monomod.domain.exchangerate.IRateInteractor
import com.example.monomod.domain.exchangerate.RateInteractor
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton


fun provideInteractor() = Kodein.Module{
    bind<IRateInteractor>() with singleton { RateInteractor(instance()) }
}