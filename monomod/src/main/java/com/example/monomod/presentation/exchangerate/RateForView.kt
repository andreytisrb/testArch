package com.example.monomod.presentation.exchangerate

import com.example.monomod.domain.exchangerate.entity.Rate

data class RateForView(val code: String,
                       val name: String,
                       val curRate: Float ){
    constructor(domainRate: Rate): this(domainRate.code, domainRate.name, domainRate.curRate)
}