package com.example.purelywed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.purelywed.R
import com.example.purelywed.databinding.FragmentCaterineBinding
import com.example.purelywed.model.CardItem

class CateringFragment : Fragment() {

    private var _binding: FragmentCaterineBinding? = null
    private val binding get() = _binding!!

    // Sample data with images + text
    private val sampleData = listOf(
        CardItem("Buffet style Catering", R.drawable.buffet),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCaterineBinding.inflate(inflater, container, false)
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
