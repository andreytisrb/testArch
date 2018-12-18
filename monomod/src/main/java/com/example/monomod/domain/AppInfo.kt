package com.example.monomod.domain

data class AppInfo(val codeVersion: Int,
                   val isDebug: Boolean,
                   val appVersion: String,
                   val buildType: String,
                   val buildFlavour: String)