package nikan.sravni.ru.sampleapp

import com.example.monomod.network.di.provideWebDep
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.with

val flavorKodeinModule = Kodein.Module {
            constant(tag = "baseUrl") with "https://www.cbr-xml-daily.ru/"
            import(provideWebDep())
        }