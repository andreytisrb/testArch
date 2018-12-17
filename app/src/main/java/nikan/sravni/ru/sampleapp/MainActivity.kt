package nikan.sravni.ru.sampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind

interface DiProvider{
    val mainKodein: Kodein
}

class MainActivity : AppCompatActivity(), DiProvider {
    override val mainKodein: Kodein
        get() = Kodein{
            //bind<I>()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
