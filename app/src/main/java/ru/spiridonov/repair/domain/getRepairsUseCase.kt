package ru.spiridonov.repair.domain

class getRepairsUseCase(
    private val repository: RepairRepository
) {
    operator fun invoke() = repository.getRepairs()
}