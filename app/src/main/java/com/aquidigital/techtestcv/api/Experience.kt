package com.aquidigital.techtestcv.api

data class Experience(
    val title: String,
    val dateRange: String,
    val description: String,
    val appLinks: List<AppLink>
)