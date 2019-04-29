package com.aquidigital.techtestcv.api

data class XpJson(
    val title: String,
    val dateRange: String,
    val description: String,
    val links: List<LinkJson>
)