package nikan.sravni.ru.sampleapp

import com.example.monomod.di.IMonomodKodeinProvider
import com.example.monomod.di.getMonomodKodein
import com.example.monomod.network.di.provideStubDep
import com.example.monomod.network.di.provideWebDep
import com.github.salomonbrys.kodein.Kodein

class RootDepsProvider : IMonomodKodeinProvider {
    override val kodeinModule: Kodein
        get() = Kodein {
            import(getMonomodKodein(getAppInfo()))
            import(provideWebDep())
        }
}