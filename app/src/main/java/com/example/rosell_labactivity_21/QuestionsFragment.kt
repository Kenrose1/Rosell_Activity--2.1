package com.example.rosell_labactivity_21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rosell_labactivity_21.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment() {

    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLargestPlanet.setOnClickListener {
            navigateToMultipleChoice(1)
        }

        binding.btnMostMoons.setOnClickListener {
            navigateToMultipleChoice(2)
        }

        binding.btnSpinsSide.setOnClickListener {
            navigateToMultipleChoice(3)
        }
    }

    private fun navigateToMultipleChoice(questionType: Int) {
        val bundle = Bundle().apply {
            putInt("questionType", questionType)
        }
        findNavController().navigate(R.id.action_questionsFragment_to_multipleChoiceFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
