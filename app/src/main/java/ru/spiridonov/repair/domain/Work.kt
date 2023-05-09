package ru.spiridonov.repair.domain

data class Work(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val image: String,
    val category: String,
    val workStage: WorkStage,
    val isPaid: Boolean,
)
