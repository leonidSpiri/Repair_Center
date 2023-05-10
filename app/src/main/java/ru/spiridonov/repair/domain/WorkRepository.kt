package ru.spiridonov.repair.domain

interface WorkRepository {

    fun getUserWorkList(): List<Work>
}