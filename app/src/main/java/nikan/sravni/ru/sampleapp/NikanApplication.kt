package nikan.sravni.ru.sampleapp

import androidx.multidex.MultiDexApplication
import com.example.monomod.di.IMonomodKodeinProvider
import com.example.monomod.di.monomodKodeinModule
import com.example.monomod.domain.AppInfo
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton
import com.github.salomonbrys.kodein.with

fun getAppInfo() =  AppInfo(BuildConfig.VERSION_CODE,
    BuildConfig.DEBUG,
    BuildConfig.VERSION_NAME,
    BuildConfig.BUILD_TYPE,
    BuildConfig.FLAVOR
)

class NikanApplication: MultiDexApplication(), IMonomodKodeinProvider {
    override val kodeinModule = Kodein {
        bind<AppInfo>() with singleton { getAppInfo() }
        constant("timeout") with 60L
        import(monomodKodeinModule)
        import(flavorKodeinModule)
        import(buildTypeKodeinModule)
    }

}