package ru.spiridonov.repair.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import ru.spiridonov.repair.R
import ru.spiridonov.repair.databinding.EachWorkItemBinding
import ru.spiridonov.repair.domain.Work

class WorkItemAdapter :
    ListAdapter<Work, WorkItemViewHolder>(WorkItemDiffCallback) {
    var onItemClickListener: ((Work) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkItemViewHolder {
        val layoutID =
            when (viewType) {
                WORK_ITEM -> R.layout.each_work_item
                else -> throw RuntimeException("Unknown view type: $viewType")
            }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutID,
            parent,
            false
        )
        return WorkItemViewHolder(binding)
    }

    override fun getItemViewType(position: Int) =
        WORK_ITEM


    override fun onBindViewHolder(holder: WorkItemViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            when (this) {
                is EachWorkItemBinding -> {
                    workItem = item
                }
            }
            root.setOnClickListener {
                onItemClickListener?.invoke(item)
            }

        }
    }

    companion object {
        private const val WORK_ITEM = 0
    }
}