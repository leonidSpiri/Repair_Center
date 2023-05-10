package ru.spiridonov.repair.presentation.fragments.dashboard

import androidx.lifecycle.ViewModel
import ru.spiridonov.repair.data.repository.WorkRepositoryImpl
import ru.spiridonov.repair.domain.getUserWorkListUseCase

class DashboardViewModel : ViewModel() {

    private val repository = WorkRepositoryImpl
    val userWorkList = getUserWorkListUseCase(repository).invoke()
}