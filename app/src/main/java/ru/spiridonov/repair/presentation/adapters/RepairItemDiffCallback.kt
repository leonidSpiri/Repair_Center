package ru.spiridonov.repair.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import ru.spiridonov.repair.domain.Repair

object RepairItemDiffCallback : DiffUtil.ItemCallback<Repair>() {
    override fun areItemsTheSame(oldItem: Repair, newItem: Repair) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Repair, newItem: Repair) = oldItem == newItem
}