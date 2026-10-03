package com.example.rosell_labactivity_21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rosell_labactivity_21.databinding.FragmentMultipleChoiceBinding

class MultipleChoiceFragment : Fragment() {

    private var _binding: FragmentMultipleChoiceBinding? = null
    private val binding get() = _binding!!

    private var currentQuestionType: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMultipleChoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentQuestionType = arguments?.getInt("questionType") ?: 1

        binding.tvQuestionTitle.text = when (currentQuestionType) {
            1 -> getString(R.string.title_largest)
            2 -> getString(R.string.title_most_moons)
            3 -> getString(R.string.title_spins_side)
            else -> ""
        }

        val planetButtons = listOf(
            binding.btnMercury to "MERCURY",
            binding.btnVenus to "VENUS",
            binding.btnEarth to "EARTH",
            binding.btnMars to "MARS",
            binding.btnJupiter to "JUPITER",
            binding.btnSaturn to "SATURN",
            binding.btnUranus to "URANUS",
            binding.btnNeptune to "NEPTUNE"
        )

        for ((button, planetName) in planetButtons) {
            button.setOnClickListener {
                checkAnswer(planetName)
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun checkAnswer(selectedPlanet: String) {
        var isCorrect = false
        var explanation = ""

        when (currentQuestionType) {
            1 -> {
                isCorrect = (selectedPlanet == "JUPITER")
                explanation = getString(R.string.answer_largest)
            }
            2 -> {
                isCorrect = (selectedPlanet == "SATURN")
                explanation = getString(R.string.answer_most_moons)
            }
            3 -> {
                isCorrect = (selectedPlanet == "URANUS")
                explanation = getString(R.string.answer_spins_side)
            }
        }

        val bundle = Bundle().apply {
            putBoolean("isCorrect", isCorrect)
            putString("explanation", explanation)
        }
        findNavController().navigate(R.id.action_multipleChoiceFragment_to_answersFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
