package com.aquidigital.techtestcv.api

data class CV(
    val name: String,
    val title: String,
    val description: String,
    val experience: List<Experience>
)