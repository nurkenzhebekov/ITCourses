package com.example.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.presentation.R
import com.example.presentation.databinding.FragmentOnboardingBinding
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.button.MaterialButton

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    private val courseTags = listOf(
        "B2B маркетинг", "Веб-дизайн", "Python-разработка",
        "Big Data", "Google Аналитика", "Cinema 4D", "Трафик"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addCourseTags()

        binding.buttonNext.setOnClickListener {
            // TODO
        }
    }

    private fun addCourseTags() {
        courseTags.forEach { tag ->
            val button = MaterialButton(requireContext()).apply {
                text = tag
                setBackgroundColor(resources.getColor(R.color.green_light, null))
                setTextColor(resources.getColor(R.color.white, null))
                layoutParams = FlexboxLayout.LayoutParams(
                    FlexboxLayout.LayoutParams.WRAP_CONTENT,
                    FlexboxLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    marginEnd = 16
                    bottomMargin = 16
                }
            }
            binding.flowLayoutTags.addView(button)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}