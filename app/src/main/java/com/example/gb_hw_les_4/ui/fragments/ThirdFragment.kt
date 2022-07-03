package com.example.gb_hw_les_4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gb_hw_les_4.databinding.FragmentThirdBinding
import com.example.gb_hw_les_4.getListHomeWorks
import com.example.gb_hw_les_4.ui.adapters.HomeWorkAdapter

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding: FragmentThirdBinding
        get() = _binding ?: throw RuntimeException("FragmentThirdBinding? = null")

    private val homeWorkAdapter by lazy {
        HomeWorkAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                findNavController().popBackStack()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tFragmentClassesRecycler.adapter = homeWorkAdapter
        homeWorkAdapter.submitList(getListHomeWorks())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}