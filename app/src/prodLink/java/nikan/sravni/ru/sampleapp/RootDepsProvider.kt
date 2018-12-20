package nikan.sravni.ru.sampleapp

import com.example.monomod.di.IMonomodKodeinProvider
import com.example.monomod.di.getMonomodKodein
import com.example.monomod.network.di.provideStubDep
import com.example.monomod.network.di.provideWebDep
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.with

class RootDepsProvider : IMonomodKodeinProvider {
    override val kodeinModule: Kodein
        get() = Kodein {
            import(getMonomodKodein(getAppInfo()))
            constant(tag = "baseUrl") with "https://www.cbr-xml-daily.ru/"
            import(provideWebDep())

        }
}