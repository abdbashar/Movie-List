package com.example.movielist.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.example.movielist.data.model.MovieData
import java.util.ArrayList

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    abstract val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> VB
    private lateinit var _binding: VB
    protected val binding: VB
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflate(inflater, container, false)
        setup()

        return _binding.root
    }

    abstract fun setup()
    }
