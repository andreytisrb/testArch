package com.example.monomod.presentation.exchangerate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.monomod.R
import com.example.monomod.databinding.ExchangeRateFragmentBinding
import com.example.monomod.di.IMonomodKodeinProvider
import com.example.monomod.presentation.exchangerate.di.providePresentationExchangeRate
import com.example.monomod.utils.CommonFragment
import com.github.salomonbrys.kodein.*


class ExchangeRateFragment : CommonFragment() {

    override fun init() = Kodein{
        extend((activity?.application as IMonomodKodeinProvider).kodeinModule)

        bind<CommonFragment>() with provider { this@ExchangeRateFragment }

        constant("tt") with (5)
        import(providePresentationExchangeRate())
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding:ExchangeRateFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.exchange_rate_fragment, container, false)
        binding.setLifecycleOwner(this)
        binding.viewModel = kodein.instance()
        return binding.root
    }

    companion object {
        fun newInstance() = ExchangeRateFragment()
    }

}