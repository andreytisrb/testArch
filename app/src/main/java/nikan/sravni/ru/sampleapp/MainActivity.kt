package nikan.sravni.ru.sampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.monomod.presentation.exchangerate.view.ExchangeRateFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.mainFragmentView, ExchangeRateFragment.newInstance(), "MainFragment").commitAllowingStateLoss()
    }
}
