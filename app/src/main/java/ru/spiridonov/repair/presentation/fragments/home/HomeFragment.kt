package ru.spiridonov.repair.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.spiridonov.repair.databinding.FragmentHomeBinding
import ru.spiridonov.repair.domain.Repair
import ru.spiridonov.repair.presentation.adapters.RepairItemAdapter
import ru.spiridonov.repair.utils.ShowAlert

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding == null")


    private lateinit var viewModel: HomeViewModel
    private lateinit var repairItemAdapter: RepairItemAdapter
    private var repairList = emptyList<Repair>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        repairList = viewModel.repairsList
        repairItemAdapter = RepairItemAdapter()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        repairItemAdapter.submitList(repairList)
        binding.rvRepairList.adapter = repairItemAdapter
        repairItemAdapter.onItemClickListener = {
            ShowAlert(requireActivity(), "С вами свяжется наш менеджер!")
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}