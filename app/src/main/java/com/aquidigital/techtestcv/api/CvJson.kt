package com.aquidigital.techtestcv.api

data class CvJson(
    val name: String,
    val title: String,
    val description: String,
    val experience: List<XpJson>
)