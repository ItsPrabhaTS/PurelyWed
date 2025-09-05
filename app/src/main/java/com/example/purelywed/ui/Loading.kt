package com.example.purelywed.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.purelywed.R
import com.example.purelywed.data.PreferenceManager
import com.example.purelywed.databinding.FragmentLoadingBinding


@SuppressLint("CustomSplashScreen")
class Loading : Fragment() {
    private var _binding: FragmentLoadingBinding?=null
    private val binding: FragmentLoadingBinding
        get()=_binding!!
    private lateinit var preferenceManager: PreferenceManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding= FragmentLoadingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceManager= PreferenceManager(requireContext())
        Handler(Looper.getMainLooper()).postDelayed({
            if(preferenceManager.isLoggedIn){
                findNavController().navigate(R.id.action_loading_to_homeFragment)
            }else{
                findNavController().navigate(R.id.action_loading_to_loginFragment)
            }
        },2000L)
    }
}