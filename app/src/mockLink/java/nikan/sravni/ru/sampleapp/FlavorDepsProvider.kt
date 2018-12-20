package nikan.sravni.ru.sampleapp

import com.example.monomod.di.IMonomodKodeinProvider
import com.example.monomod.di.getMonomodKodein
import com.example.monomod.network.di.provideStubDep
import com.github.salomonbrys.kodein.Kodein

val flavorKodeinModule = Kodein.Module {
    import(provideStubDep())
}
