package com.mosso.test.main.feature.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mosso.test.databinding.DetailCategoriesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCategoriesFragment : Fragment() {


   private var _binding: DetailCategoriesFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = DetailCategoriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}