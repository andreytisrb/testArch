package com.example.monomod.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance


abstract class CommonFragment: Fragment(){

    protected val kodein: Kodein by lazy { init()}


    abstract fun init(): Kodein
}