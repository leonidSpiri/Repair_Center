package ru.spiridonov.repair.domain

data class Repair(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val image: String,
    val category: String,
    val isFavorite: Boolean
)
