package com.example.e_wallet.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.e_wallet.R
import com.example.e_wallet.databinding.FragmentSignBinding
import com.example.e_wallet.presentation.DrawerLayoutInteractor


class SignFragment : Fragment() {

    private var _binding: FragmentSignBinding? = null
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignBinding.inflate(inflater, container, false)
        val typeface = container?.let { ResourcesCompat.getFont(it.context, R.font.lato) }
        binding.time.typeface = typeface
        binding.date.typeface = typeface
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as DrawerLayoutInteractor).disableDrawerLayout()
        setListners()

    }

    private fun setListners() {
        binding.signIn.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, HomeFragment())
            transaction.commit()
            (activity as DrawerLayoutInteractor).enableDrawerLayout()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}