package nikan.sravni.ru.sampleapp

import androidx.multidex.MultiDexApplication
import com.example.monomod.di.IMonomodKodeinProvider
import com.example.monomod.di.monomodKodeinModule
import com.example.monomod.domain.AppInfo
import com.github.salomonbrys.kodein.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

fun getAppInfo() =  AppInfo(BuildConfig.VERSION_CODE,
    BuildConfig.DEBUG,
    BuildConfig.VERSION_NAME,
    BuildConfig.BUILD_TYPE,
    BuildConfig.FLAVOR
)

class NikanApplication: MultiDexApplication(), IMonomodKodeinProvider {
    override val kodeinModule = Kodein {
        bind<AppInfo>() with singleton { getAppInfo() }

        bind<Cicerone<Router>>() with singleton { Cicerone.create() }
        bind<NavigatorHolder>() with singleton { instance<Cicerone<Router>>().navigatorHolder }


        constant("timeout") with 60L
        import(monomodKodeinModule)
        import(flavorKodeinModule)
        import(buildTypeKodeinModule)
    }

}