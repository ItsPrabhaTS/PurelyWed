package com.example.purelywed.ui

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.purelywed.R
import com.example.purelywed.data.PreferenceManager
import com.example.purelywed.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val preferenceManager: PreferenceManager by lazy { PreferenceManager(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.materialButtonLogin.setOnClickListener {
            val email = binding.emailInput.text?.toString()?.trim() ?: ""
            val password = binding.passwordInput.text?.toString()?.trim() ?: ""

            if (email.isEmpty()) {
                binding.emailInputLayout.error = "Enter email"
                return@setOnClickListener
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailInputLayout.error = "Invalid email format"
                return@setOnClickListener
            } else {
                binding.emailInputLayout.error = null
            }

            if (password.isEmpty()) {
                binding.passwordInputLayout.error = "Enter password"
                return@setOnClickListener
            } else {
                binding.passwordInputLayout.error = null
            }

            preferenceManager.isLoggedIn = true
            preferenceManager.email = email
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }
}
