package com.example.monomod.di

import com.example.monomod.domain.AppInfo
import com.example.monomod.domain.di.provideInteractor
import com.example.monomod.network.di.provideStubDep
import com.example.monomod.network.di.provideWebDep
import com.example.monomod.presentation.exchangerate.di.providePresentationExchangeRate
import com.github.salomonbrys.kodein.*
import retrofit2.Retrofit

interface IMonomodKodeinProvider {
    val kodeinModule: Kodein
}

fun getMonomodKodein(appInfo: AppInfo) = Kodein.Module {
    bind<Retrofit>() with provider {
        Retrofit.Builder()
            .client(instance())
            .baseUrl(instance<String>("baseUrl"))
            .build()
    }

    bind<AppInfo>() with singleton { appInfo }

    import(provideInteractor())

//    if(appInfo.buildVariant.contains("Stub"))
        import(provideStubDep())
//    else
//        import(provideWebDep())


}