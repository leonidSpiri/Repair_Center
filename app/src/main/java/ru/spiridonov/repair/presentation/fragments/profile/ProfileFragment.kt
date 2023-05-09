package ru.spiridonov.repair.presentation.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.spiridonov.repair.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding ?: throw RuntimeException("FragmentProfileBinding == null")

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        observeViewModel()
        buttonClickListener()
    }

    private fun buttonClickListener() {
        binding.btnLogout.setOnClickListener {
            viewModel.logout()
            findNavController().popBackStack()
            //requireActivity().startActivity(LoginActivity.newIntent(requireContext()))
        }
    }

    private fun observeViewModel() {
        viewModel.user.observe(viewLifecycleOwner) {
            if (it != null)
                binding.accountItem = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}