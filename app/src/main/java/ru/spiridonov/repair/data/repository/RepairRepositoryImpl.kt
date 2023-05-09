package ru.spiridonov.repair.data.repository

import ru.spiridonov.repair.data.network.RepairApi
import ru.spiridonov.repair.domain.RepairRepository

object RepairRepositoryImpl : RepairRepository {
    override fun getRepairs() = RepairApi.repairs
}