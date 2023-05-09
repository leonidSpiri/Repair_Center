package ru.spiridonov.repair.presentation.fragments.home

import androidx.lifecycle.ViewModel
import ru.spiridonov.repair.data.repository.RepairRepositoryImpl
import ru.spiridonov.repair.domain.getRepairsUseCase

class HomeViewModel : ViewModel() {
    private val repository = RepairRepositoryImpl
    val repairsList = getRepairsUseCase(repository).invoke()
}

