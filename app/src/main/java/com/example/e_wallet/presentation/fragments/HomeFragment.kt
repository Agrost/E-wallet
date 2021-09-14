package com.example.e_wallet.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.e_wallet.data.Answer
import com.example.e_wallet.databinding.FragmentHomeBinding
import com.example.e_wallet.di.DaggerViewModelFactory
import com.example.e_wallet.di.appComponent
import com.example.e_wallet.presentation.DrawerLayoutInteractor
import com.example.e_wallet.presentation.recycler.RecyclerAdapter
import com.example.e_wallet.presentation.viewmodels.HomeViewModel
import java.text.DecimalFormat
import javax.inject.Inject


class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDagger()
        getRecycler()
        setOnclickListeners()
    }

    private fun initDagger() {
        requireActivity().appComponent
            .registerHomeComponent()
            .create()
            .inject(this)
    }

    private fun getRecycler() {
        LinearSnapHelper().attachToRecyclerView(binding.cardRecycler)
        val recyclerAdapter = RecyclerAdapter()
        homeViewModel.getAnswer().observe(viewLifecycleOwner) {
            if (it is Answer.Success) {
                recyclerAdapter.items = it.personCardList
                val dec = DecimalFormat("#,###")
                binding.balance.text = dec.format(it.currentBalance)
            } else {
                //Do some else
            }
        }
        binding.cardRecycler.adapter = recyclerAdapter
    }

    private fun setOnclickListeners() {
        binding.menu.setOnClickListener {
            (activity as DrawerLayoutInteractor).openDrawerLayout()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}