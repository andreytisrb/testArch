package nikan.sravni.ru.sampleapp

import androidx.multidex.MultiDexApplication
import com.example.monomod.di.IMonomodKodeinProvider
import com.example.monomod.di.getMonomodKodein
import com.example.monomod.domain.AppInfo
import com.github.salomonbrys.kodein.Kodein

class NikanApplication: MultiDexApplication(), IMonomodKodeinProvider {
    override val kodeinModule: Kodein
        get() = Kodein{
            import(getMonomodKodein(AppInfo(BuildConfig.VERSION_CODE,
                BuildConfig.DEBUG,
                BuildConfig.VERSION_NAME,
                BuildConfig.BUILD_TYPE,
                BuildConfig.FLAVOR
                )))
        }

    override fun onCreate() {
        super.onCreate()
    }
}