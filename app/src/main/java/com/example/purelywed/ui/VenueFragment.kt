package com.example.purelywed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.purelywed.R
import com.example.purelywed.databinding.FragmentVenueBinding
import com.example.purelywed.model.CardItem

class VenueFragment : Fragment() {

    private var _binding: FragmentVenueBinding? = null
    private val binding get() = _binding!!

    // Sample data with images + text
    private val sampleData = listOf(
        CardItem("Make your forever begin by the sea", R.drawable.beach),
        CardItem("Celebrate love in grand style.", R.drawable.hall),
        CardItem("Tie the knot above the clouds.", R.drawable.hill),
        CardItem("Begin forever in timeless royalty.", R.drawable.fort),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVenueBinding.inflate(inflater, container, false)
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
