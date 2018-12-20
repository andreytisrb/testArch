package com.example.monomod.presentation.exchangerate.di

import androidx.lifecycle.ViewModelProviders
import com.example.monomod.presentation.exchangerate.viewmodel.ExchangeRateViewModel
import com.example.monomod.presentation.exchangerate.viewmodel.IExchangeRateViewModel
import com.example.monomod.utils.CommonFragment
import com.github.salomonbrys.kodein.*

fun providePresentationExchangeRate() = Kodein.Module{
    bind<IExchangeRateViewModel>() with singleton {
        ViewModelProviders.
            of(instance<CommonFragment>())[ExchangeRateViewModel::class.java].
            apply { init(instance()) } }
}

