package com.ariefrahman.core.domain.model

data class Recipe (
    val title: String,
    val thumb: String,
    val key: String,
    val times: String,
    val portion: String,
    val dificulty: String,
    val favorite: Boolean = false
)