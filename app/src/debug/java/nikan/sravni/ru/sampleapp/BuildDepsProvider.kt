package nikan.sravni.ru.sampleapp

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.provider
import okhttp3.logging.HttpLoggingInterceptor


val buildTypeKodeinModule = Kodein.Module {
            bind<Interceptor>() with provider { HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }}
        }