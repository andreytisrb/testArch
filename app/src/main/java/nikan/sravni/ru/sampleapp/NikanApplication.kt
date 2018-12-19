package nikan.sravni.ru.sampleapp

import androidx.multidex.MultiDexApplication
import com.example.monomod.di.IMonomodKodeinProvider
import com.example.monomod.domain.AppInfo

fun getAppInfo() =  AppInfo(BuildConfig.VERSION_CODE,
    BuildConfig.DEBUG,
    BuildConfig.VERSION_NAME,
    BuildConfig.BUILD_TYPE,
    BuildConfig.FLAVOR
)

class NikanApplication: MultiDexApplication(), IMonomodKodeinProvider {
    override val kodeinModule = RootDepsProvider().kodeinModule

    override fun onCreate() {
        super.onCreate()
    }


}