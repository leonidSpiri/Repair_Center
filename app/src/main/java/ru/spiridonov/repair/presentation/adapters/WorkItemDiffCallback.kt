package ru.spiridonov.repair.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import ru.spiridonov.repair.domain.Work

object WorkItemDiffCallback : DiffUtil.ItemCallback<Work>() {
    override fun areItemsTheSame(oldItem: Work, newItem: Work) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Work, newItem: Work) = oldItem == newItem
}