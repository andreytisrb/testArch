package com.example.monomod.presentation.exchangerate

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.monomod.R
import com.example.monomod.databinding.ExchangerateItemViewBinding

class RateAdapter(val rateList: List<RateForView>) : RecyclerView.Adapter<RateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder =
        RateViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.exchangerate_item_view,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = rateList.size

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        holder.itemBinding.rate = rateList[position]
    }
}

class RateViewHolder(val itemBinding: ExchangerateItemViewBinding) : RecyclerView.ViewHolder(itemBinding.root)