package ru.spiridonov.repair.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import ru.spiridonov.repair.R
import ru.spiridonov.repair.databinding.EachRepairItemBinding
import ru.spiridonov.repair.databinding.EachRepairItemComputerBinding
import ru.spiridonov.repair.databinding.EachRepairItemTabletBinding
import ru.spiridonov.repair.domain.Repair

class RepairItemAdapter :
    ListAdapter<Repair, RepairItemViewHolder>(RepairItemDiffCallback) {
    var onItemClickListener: ((Repair) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepairItemViewHolder {
        val layoutID =
            when (viewType) {
                REPAIR_ITEM -> R.layout.each_repair_item
                REPAIR_ITEM_TABLET -> R.layout.each_repair_item_tablet
                REPAIR_ITEM_COMPUTER -> R.layout.each_repair_item_computer
                else -> throw RuntimeException("Unknown view type: $viewType")
            }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutID,
            parent,
            false
        )
        return RepairItemViewHolder(binding)
    }

    override fun getItemViewType(position: Int) =
        when (getItem(position).category) {
            "Планшеты" -> REPAIR_ITEM_TABLET
            "Ноутбуки" -> REPAIR_ITEM_COMPUTER
            else -> REPAIR_ITEM
        }


    override fun onBindViewHolder(holder: RepairItemViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            when (this) {
                is EachRepairItemBinding -> {
                    repairItem = item
                }
                is EachRepairItemComputerBinding -> {
                    repairItem = item
                }
                is EachRepairItemTabletBinding -> {
                    repairItem = item
                }
            }
            root.setOnClickListener {
                onItemClickListener?.invoke(item)
            }

        }
    }

    companion object {
        private const val REPAIR_ITEM = 0
        private const val REPAIR_ITEM_TABLET = 1
        private const val REPAIR_ITEM_COMPUTER = 2
    }
}