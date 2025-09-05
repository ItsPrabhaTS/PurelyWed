package com.example.purelywed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.purelywed.R
import com.example.purelywed.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Button click listeners
        binding.btnVenue.setOnClickListener {
            loadFragment(VenueFragment())
        }
        binding.btnCamera.setOnClickListener {
            loadFragment(PhotoFragment())
        }
        binding.btnFood.setOnClickListener {
            loadFragment(CateringFragment())
        }
        binding.btnMehndi.setOnClickListener {
            loadFragment(MehndiFragment())
        }
        binding.btnTour.setOnClickListener {
            loadFragment(HolidayFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {

        binding.tvWelcome.visibility = View.GONE

        childFragmentManager.beginTransaction()
            .replace(R.id.homeFragmentContainer, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
