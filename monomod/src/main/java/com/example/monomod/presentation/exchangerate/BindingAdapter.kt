package com.example.monomod.presentation.exchangerate

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter(value = ["rateList"])
fun bindListToRecycler(view: RecyclerView, rateList: List<RateForView>) {
    val rvAdapter = RateAdapter(rateList)
    view.adapter = rvAdapter
}