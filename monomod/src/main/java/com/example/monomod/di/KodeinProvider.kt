package com.example.monomod.di

import com.example.monomod.domain.AppInfo
import com.example.monomod.domain.di.provideInteractor
import com.example.monomod.network.di.provideStubDep
import com.example.monomod.repository.di.provideRepository
import com.github.salomonbrys.kodein.*
import retrofit2.Retrofit

interface IMonomodKodeinProvider {
    val kodeinModule: Kodein
}

fun getMonomodKodein(appInfo: AppInfo) = Kodein.Module {

    bind<AppInfo>() with singleton { appInfo }

    import(provideInteractor())
    import(provideRepository())


}