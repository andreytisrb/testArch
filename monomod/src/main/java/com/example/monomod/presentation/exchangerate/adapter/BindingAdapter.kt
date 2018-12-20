package com.example.monomod.presentation.exchangerate.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.monomod.presentation.exchangerate.viewdata.RateForView

@BindingAdapter(value = ["rateList"])
fun bindListToRecycler(view: RecyclerView, rateList: List<RateForView>?) {
    rateList?.let {
        val rvAdapter = RateAdapter(rateList)
        view.adapter = rvAdapter
    }
}