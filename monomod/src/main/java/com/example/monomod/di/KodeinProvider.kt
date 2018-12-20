package com.example.monomod.di

import com.example.monomod.domain.di.provideInteractor
import com.example.monomod.repository.di.provideRepository
import com.github.salomonbrys.kodein.Kodein

interface IMonomodKodeinProvider {
    val kodeinModule: Kodein
}

val monomodKodeinModule = Kodein.Module {
    import(provideInteractor())
    import(provideRepository())
}