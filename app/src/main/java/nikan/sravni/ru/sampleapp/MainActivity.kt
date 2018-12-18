package nikan.sravni.ru.sampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.monomod.presentation.exchangerate.ExchangeRateFragment
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.mainFragmentView, ExchangeRateFragment.newInstance(), "MainFragment").commitAllowingStateLoss()
    }
}
