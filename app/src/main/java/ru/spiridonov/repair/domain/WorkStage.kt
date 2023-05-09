package ru.spiridonov.repair.domain

enum class WorkStage {
    DIAGNOSTICS,
    REPAIR,
    TESTING,
    DELIVERY,
    PAYMENT,
    COMPLETED
}