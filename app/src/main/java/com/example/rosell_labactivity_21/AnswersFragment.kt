package com.example.rosell_labactivity_21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rosell_labactivity_21.databinding.FragmentAnswersBinding

class AnswersFragment : Fragment() {

    private var _binding: FragmentAnswersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnswersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isCorrect = arguments?.getBoolean("isCorrect") ?: false
        val explanation = arguments?.getString("explanation") ?: ""

        if (isCorrect) {
            binding.tvResult.text = getString(R.string.result_correct)
            binding.tvResult.setTextColor(resources.getColor(android.R.color.holo_green_dark, null))
        } else {
            binding.tvResult.text = getString(R.string.result_wrong)
            binding.tvResult.setTextColor(resources.getColor(android.R.color.holo_red_dark, null))
        }

        binding.tvExplanation.text = explanation

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_answersFragment_to_questionsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
