package com.example.purelywed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.purelywed.R
import com.example.purelywed.databinding.FragmentHolidayBinding
import com.example.purelywed.model.CardItem

class HolidayFragment : Fragment() {

    private var _binding: FragmentHolidayBinding? = null
    private val binding get() = _binding!!

    // Sample data with images + text
    private val sampleData = listOf(
        CardItem("Fall in love with traditions in Japan", R.drawable.japan),
        CardItem("Romance in the Alps of Switzerland", R.drawable.switzerland),
        CardItem("Say ‘Je t’aime’ in Paris", R.drawable.paris),
        CardItem("Heaven on Earth – Kashmir", R.drawable.kashmir),
        CardItem("Chase Northern Lights in Norway", R.drawable.norway),
        CardItem("Sail into love in Venice", R.drawable.venezia),
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHolidayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = Adapter(sampleData) { item ->
            Toast.makeText(requireContext(), "Clicked: ${item.text}", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
