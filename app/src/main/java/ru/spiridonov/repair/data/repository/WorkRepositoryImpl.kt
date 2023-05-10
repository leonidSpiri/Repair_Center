package ru.spiridonov.repair.data.repository

import ru.spiridonov.repair.data.network.WorkApi
import ru.spiridonov.repair.domain.WorkRepository

object WorkRepositoryImpl : WorkRepository {
    override fun getUserWorkList() = WorkApi.works
}