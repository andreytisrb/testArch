package com.example.monomod.presentation.exchangerate.viewdata

import com.example.monomod.domain.exchangerate.entity.Rate

data class RateForView(val code: String,
                       val name: String,
                       val curRate: String ){
    constructor(domainRate: Rate): this(domainRate.code, domainRate.name, String.format("%.1f",domainRate.curRate))
}