package nikan.sravni.ru.sampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.monomod.presentation.exchangerate.view.ExchangeRateFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Command

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.mainFragmentView, ExchangeRateFragment.newInstance(), "MainFragment").commitAllowingStateLoss()
    }

    val navigtor = object: Navigator{
        override fun applyCommands(commands: Array<out Command>?) {
        }
    }
}
