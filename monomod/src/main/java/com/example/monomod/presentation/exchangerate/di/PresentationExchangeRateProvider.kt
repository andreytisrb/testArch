package com.example.monomod.presentation.exchangerate.di

import androidx.lifecycle.ViewModelProviders
import com.example.monomod.R
import com.example.monomod.di.IMonomodKodeinProvider
import com.example.monomod.presentation.exchangerate.ExchangeRateFragment
import com.example.monomod.presentation.exchangerate.ExchangeRateViewModel
import com.example.monomod.presentation.exchangerate.IExchangeRateViewModel
import com.example.monomod.utils.CommonFragment
import com.github.salomonbrys.kodein.*

fun providePresentationExchangeRate() = Kodein.Module{
    bind<IExchangeRateViewModel>() with singleton {
        ViewModelProviders.
            of(instance<CommonFragment>())[ExchangeRateViewModel::class.java].
            apply { init(instance()) } }
}

