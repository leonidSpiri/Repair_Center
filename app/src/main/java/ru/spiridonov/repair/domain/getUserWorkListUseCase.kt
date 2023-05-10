package ru.spiridonov.repair.domain

class getUserWorkListUseCase(
    private val repository: WorkRepository
) {
    operator fun invoke() = repository.getUserWorkList()
}