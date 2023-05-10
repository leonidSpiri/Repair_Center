package ru.spiridonov.repair.presentation.fragments.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.spiridonov.repair.databinding.FragmentDashboardBinding
import ru.spiridonov.repair.domain.Work
import ru.spiridonov.repair.presentation.adapters.WorkItemAdapter

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding: FragmentDashboardBinding
        get() = _binding ?: throw RuntimeException("FragmentDashboardBinding == null")


    private lateinit var viewModel: DashboardViewModel
    private lateinit var workItemAdapter: WorkItemAdapter
    private var userWorkList = emptyList<Work>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        userWorkList = viewModel.userWorkList
        workItemAdapter = WorkItemAdapter()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        workItemAdapter.submitList(userWorkList)
        binding.rvWorkList.adapter = workItemAdapter
        workItemAdapter.onItemClickListener = {
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}