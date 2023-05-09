package ru.spiridonov.repair.domain

interface RepairRepository {

    fun getRepairs(): List<Repair>
}