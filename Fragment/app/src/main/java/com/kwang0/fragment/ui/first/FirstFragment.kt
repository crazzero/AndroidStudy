package com.kwang0.fragment.ui.first

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kwang0.fragment.R
import com.kwang0.fragment.databinding.FirstFragmentBinding
import com.kwang0.fragment.databinding.ThirdFragmentBinding

class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstViewModel
    private var _binding: FirstFragmentBinding? = null
    private val binding get() = _binding!!
    private var count = 0

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FirstFragmentBinding.inflate(inflater, container, false)

        binding.firstText.text = "${context?.getString(R.string.first_fragment_title)} ${count++}"
        binding.buttonAddFirstA.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.firstContainer, FirstAFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        binding.buttonAddFirstB.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.firstContainer, FirstBFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        binding.buttonStartFirstSecond.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.rootContainer, FirstSecondFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
    }

    override fun onDestroyView() {
        Log.e("First", "onDestroyView")
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}