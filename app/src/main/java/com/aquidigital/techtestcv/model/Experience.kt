package com.aquidigital.techtestcv.model

data class Experience(
    val title: String,
    val dateRange: String,
    val description: String,
    val appLinks: List<AppLink>
)